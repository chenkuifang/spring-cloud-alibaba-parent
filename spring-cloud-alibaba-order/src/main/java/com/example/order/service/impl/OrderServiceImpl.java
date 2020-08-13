package com.example.order.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.example.common.dto.OrderDTO;
import com.example.common.model.Goods;
import com.example.common.model.OrderInfo;
import com.example.common.model.Points;
import com.example.order.feign.GoodsClient;
import com.example.order.feign.PointsClient;
import com.example.order.mapper.OrderInfoMapper;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单服务实现
 *
 * @author quifar
 */
@Slf4j
@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;
    private OrderInfoMapper orderInfoMapper;

    private GoodsClient goodsClient;
    private PointsClient pointsClient;

    @Override
    public List<OrderDTO> list() {
        return orderMapper.list();
    }

    @Transactional
    @Override
    public Boolean createOrder1() {
        return orderHandler();
    }

    @GlobalTransactional
    @Override
    public Boolean createOrder2() {
        log.info("开始全局事务，XID = " + RootContext.getXID());
        OrderDTO orderDTO = getOrder();
        Integer userId = orderDTO.getUserId();
        BigDecimal totalPrice = orderDTO.getTotalPrice();
        List<OrderInfo> orderInfos = orderDTO.getOrderInfos();
        if (orderInfos.isEmpty()) {
            throw new IllegalArgumentException();
        }

        // 创建订单
        Boolean createOrder = orderMapper.create(orderDTO);
        Boolean createInfo = orderInfoMapper.createBatch(orderInfos);

        // 扣库存 && 积分记录
        if (createOrder && createInfo) {
            orderInfos.forEach(info -> deductStorage(info.getGoodsId(), info.getOrderCount()));
            createPoint(userId, totalPrice.intValue());
        }

        return true;
    }

    private Boolean orderHandler() {
        OrderDTO orderDTO = getOrder();
        Integer userId = orderDTO.getUserId();
        BigDecimal totalPrice = orderDTO.getTotalPrice();
        List<OrderInfo> orderInfos = orderDTO.getOrderInfos();
        if (orderInfos.isEmpty()) {
            throw new IllegalArgumentException();
        }

        // 创建订单
        Boolean createOrder = orderMapper.create(orderDTO);
        Boolean createInfo = orderInfoMapper.createBatch(orderInfos);

        // 扣库存 && 积分记录
        if (createOrder && createInfo) {
            orderInfos.forEach(info -> deductStorage(info.getGoodsId(), info.getOrderCount()));
            createPoint(userId, totalPrice.intValue());
        }

        return true;
    }

    /**
     * 扣减库存
     *
     * @param goodsId
     * @param orderCount
     * @return
     */
    private Boolean deductStorage(int goodsId, int orderCount) {
        return goodsClient.deductStorage(goodsId, orderCount);
    }

    /**
     * 扣减库存
     *
     * @param userId     userId
     * @param orderPrice orderPrice
     * @return
     */
    private Boolean createPoint(int userId, int orderPrice) {
        Points points = new Points();
        points.setUserId(userId);
        points.setCount(orderPrice / 10);
        return pointsClient.create(points);
    }

    /***
     * 构造订单参数
     * @return
     */
    private OrderDTO getOrder() {
        int orderCount1 = 6;
        int orderCount2 = 4;

        int orderId = RandomUtils.nextInt(1000, 9999);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderId);
        orderDTO.setCount(orderCount1 + orderCount2);
        orderDTO.setTotalPrice(new BigDecimal(1000));
        orderDTO.setUserId(1001);

        int goodsId1 = 10001;
        Goods goods1 = goodsClient.get(goodsId1);
        Assert.notNull(goods1, "商品信息不能为空");
        if (goods1.getStorage() < orderCount1) {
            throw new IllegalArgumentException("商品库存不足");
        }
        String goodsName1 = goods1.getName();
        OrderInfo orderInfo1 = new OrderInfo(orderId, goodsId1, goodsName1, orderCount1);

        int goodsId2 = 10002;
        Goods goods2 = goodsClient.get(goodsId2);
        Assert.notNull(goods2, "商品信息不能为空");
        String goodsName2 = goods2.getName();
        if (goods2.getStorage() < orderCount2) {
            throw new IllegalArgumentException("商品库存不足");
        }
        OrderInfo orderInfo2 = new OrderInfo(orderId, goodsId2, goodsName2, orderCount2);

        List<OrderInfo> orderInfos = CollUtil.newArrayList(orderInfo1, orderInfo2);
        orderDTO.setOrderInfos(orderInfos);

        return orderDTO;
    }

}
