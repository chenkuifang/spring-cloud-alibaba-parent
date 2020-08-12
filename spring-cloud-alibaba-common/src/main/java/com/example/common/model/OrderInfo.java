package com.example.common.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * orderInfo
 *
 * @author Quifar
 * @version 1.0
 */
@Data
@RequiredArgsConstructor
public class OrderInfo {
    private Integer orderId;
    private Integer goodsId;
    private String goodsName;
}
