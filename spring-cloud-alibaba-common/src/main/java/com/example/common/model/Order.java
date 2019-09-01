package com.example.common.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述
 *
 * @author: Quifar
 * @version: 1.0
 */
@Data
@RequiredArgsConstructor
public class Order {

    private Integer count;
    private BigDecimal totalPrice;
    private String buyer;
    private List<Goods> goods;
}
