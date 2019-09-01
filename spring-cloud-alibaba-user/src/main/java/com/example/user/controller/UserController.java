package com.example.user.controller;

import com.example.common.model.Goods;
import com.example.common.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单控制器
 *
 * @author: Quifar
 * @version: 1.0
 */
@RequestMapping("/user")
@RestController
public class UserController {

    //基于RestTemplate调用Goods服务的接口
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public Order get() {
        List<Goods> goods = restTemplate.getForObject("http://goods-service/goods/list", List.class);
        Order order = new Order();
        order.setCount(100);
        order.setBuyer("quifar");
        order.setTotalPrice(new BigDecimal(2000));
        order.setGoods(goods);
        return order;
    }
}
