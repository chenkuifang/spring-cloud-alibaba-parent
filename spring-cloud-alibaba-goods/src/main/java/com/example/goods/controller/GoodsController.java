package com.example.goods.controller;

import com.example.common.model.Goods;
import com.example.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add")
    public String add() {
        Goods goods =new Goods();
        goods.setName("apple");
        goods.setPrice(new BigDecimal(200));
        return goodsService.create(goods).toString();
    }
}
