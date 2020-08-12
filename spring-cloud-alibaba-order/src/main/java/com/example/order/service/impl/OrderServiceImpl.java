package com.example.order.service.impl;

import com.example.common.dto.OrderDTO;
import com.example.common.model.OrderInfo;
import com.example.order.mapper.OrderInfoMapper;
import com.example.order.mapper.OrderMapper;
import com.example.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author quifar
 */
@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;
    private OrderInfoMapper orderInfoMapper;

    @Override
    public List<OrderDTO> list() {
        return orderMapper.list();
    }

    @Transactional
    @Override
    public Boolean createOrder(OrderDTO orderDTO) {
        List<OrderInfo> orderInfos = orderDTO.getOrderInfos();
        if (orderInfos.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Boolean createOrder = orderMapper.create(orderDTO);
        Boolean createInfo = orderInfoMapper.createBatch(orderInfos);
        return createOrder && createInfo;
    }
}
