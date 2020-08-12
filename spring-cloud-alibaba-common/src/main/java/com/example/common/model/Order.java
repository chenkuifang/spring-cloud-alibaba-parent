package com.example.common.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * order
 *
 * @author Quifar
 * @version 1.0
 */
@Data
@RequiredArgsConstructor
public class Order {
    private Integer orderId;
    private Integer count;
    private BigDecimal totalPrice;
    private Integer userId;
}
