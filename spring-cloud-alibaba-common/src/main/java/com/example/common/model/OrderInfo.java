package com.example.common.model;

import lombok.Data;

/**
 * orderInfo
 *
 * @author Quifar
 * @version 1.0
 */
@Data
public class OrderInfo {
    public OrderInfo() {
    }

    private Integer orderId;
    private Integer goodsId;
    private String goodsName;
    private Integer orderCount;

    public OrderInfo(Integer orderId, Integer goodsId, String goodsName, Integer orderCount) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.orderCount = orderCount;
    }
}
