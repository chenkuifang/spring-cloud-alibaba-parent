package com.example.goods.controller;

import cn.hutool.core.collection.CollUtil;
import com.example.common.model.Goods;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品的控制器
 *
 * @author: quifar
 * @version: 1.0
 */
@RequestMapping("/goods")
@RestController
public class GoodsController {

    @GetMapping("/list")
    public List<Goods> list() {
        Goods goods1 = new Goods(1001, "电脑", new BigDecimal(5000));
        Goods goods2 = new Goods(1002, "风扇", new BigDecimal(200));
        Goods goods3 = new Goods(1003, "手机", new BigDecimal(2000));

        List<Goods> goodsList = CollUtil.newArrayList(goods1, goods2, goods3);

        return goodsList;
    }
}
