package com.example.order.service;

import com.example.common.dto.OrderDTO;

import java.util.List;

/**
 * @author quifar
 */
public interface OrderService {

    List<OrderDTO> list();

    Boolean createOrder1();

    Boolean createOrder2();
}
