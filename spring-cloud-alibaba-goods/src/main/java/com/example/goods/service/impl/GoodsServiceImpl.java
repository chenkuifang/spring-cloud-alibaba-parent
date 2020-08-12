package com.example.goods.service.impl;

import com.example.common.model.Goods;
import com.example.goods.mapper.GoodsMapper;
import com.example.goods.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service
 *
 * @author quifar
 */
@AllArgsConstructor
@Service
public class GoodsServiceImpl implements GoodsService {
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> list() {
        return goodsMapper.list();
    }

    @Override
    public Boolean create(Goods goods) {
        return goodsMapper.create(goods);
    }
}
