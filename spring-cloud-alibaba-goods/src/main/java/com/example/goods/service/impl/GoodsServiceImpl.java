package com.example.goods.service.impl;

import com.example.common.model.Goods;
import com.example.goods.mapper.GoodsMapper;
import com.example.goods.service.GoodsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service
 *
 * @author quifar
 */
@Slf4j
@AllArgsConstructor
@Service
public class GoodsServiceImpl implements GoodsService {
    private GoodsMapper goodsMapper;

    @Override
    public Goods get(Integer id) {
        return goodsMapper.get(id);
    }

    @Override
    public List<Goods> list() {
        return goodsMapper.list();
    }

    @Override
    public Boolean create(Goods goods) {
        return goodsMapper.create(goods);
    }

    @Override
    public Boolean deductStorage(Integer id, Integer orderCount) {
        Goods goods = goodsMapper.get(id);
        if (goods == null) {
            log.warn("商品编号无效");
            return false;
        }
        if (goods.getStorage() < orderCount) {
            log.warn("商品库存不足");
            return false;
        }

        Goods updateGoods = new Goods();
        updateGoods.setId(id);
        updateGoods.setStorage(goods.getStorage() - orderCount);
        return goodsMapper.update(updateGoods);
    }
}
