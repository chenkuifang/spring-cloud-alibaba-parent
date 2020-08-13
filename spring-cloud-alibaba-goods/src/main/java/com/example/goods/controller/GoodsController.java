package com.example.goods.controller;

import com.example.common.model.Goods;
import com.example.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品的控制器
 *
 * @author quifar
 * @version 1.0
 */
@RequestMapping("/goods")
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public List<Goods> list() {
        return goodsService.list();
    }

    @GetMapping("/get")
    public Goods get(@RequestParam("id") Integer id) {
        return goodsService.get(id);
    }

    @PostMapping("/deductStorage")
    public Boolean deductStorage(@RequestParam("id") Integer id, @RequestParam("orderCount") Integer orderCount) {
       return  goodsService.deductStorage(id,orderCount);
    }

    @PostMapping("/create")
    public String create() {
        Goods goods = new Goods();
        goods.setId(10001);
        goods.setName("苹果");
        goods.setPrice(new BigDecimal(20));
        goods.setStorage(20);
        goodsService.create(goods);

        Goods goods2 = new Goods();
        goods2.setId(10002);
        goods2.setName("西红柿");
        goods2.setPrice(new BigDecimal(15));
        goods2.setStorage(30);
        return goodsService.create(goods2).toString();
    }
}
