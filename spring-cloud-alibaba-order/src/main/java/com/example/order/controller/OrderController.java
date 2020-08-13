package com.example.order.controller;

import com.example.common.dto.OrderDTO;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单控制器
 *
 * @author Quifar
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public List<OrderDTO> list() {
        return orderService.list();
    }

    @PostMapping("/create")
    public String create() {
        return orderService.createOrder1().toString();
    }

    @PostMapping("/create2")
    public String create2() {
        return orderService.createOrder2().toString();
    }
}
