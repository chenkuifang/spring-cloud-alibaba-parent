package com.example.order.feign;

import com.example.common.model.Goods;
import com.example.order.feign.fallback.GoodsClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商品feign调用
 *
 * @author quifar
 */
@FeignClient(name = "goods-service", fallback = GoodsClientFallback.class)
public interface GoodsClient {

    @GetMapping("/goods/get")
    Goods get(@RequestParam("id") Integer id);

    @PostMapping("/goods/deductStorage")
    Boolean deductStorage(@RequestParam("id") Integer id, @RequestParam("orderCount") Integer orderCount);
}
