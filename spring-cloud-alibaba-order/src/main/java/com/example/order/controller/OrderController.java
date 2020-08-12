package com.example.order.controller;

import com.example.common.dto.OrderDTO;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<OrderDTO> getOrder() {
        return orderService.list();
    }
}
