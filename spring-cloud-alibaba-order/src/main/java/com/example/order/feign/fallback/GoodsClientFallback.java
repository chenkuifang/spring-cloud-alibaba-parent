package com.example.order.feign.fallback;

import com.example.common.model.Goods;
import com.example.order.feign.GoodsClient;
import org.springframework.stereotype.Component;

@Component
public class GoodsClientFallback implements GoodsClient {
    @Override
    public Goods get(Integer id) {
        return null;
    }

    @Override
    public Boolean deductStorage(Integer id, Integer orderCount) {
        return false;
    }
}
