package com.example.goods.service;

import com.example.common.model.Goods;

import java.util.List;

/**
 * service
 * @author quifar
 */
public interface GoodsService {

    List<Goods> list();

    Boolean create(Goods goods);
}
