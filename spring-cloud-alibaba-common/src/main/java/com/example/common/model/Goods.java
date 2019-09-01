package com.example.common.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * goods
 *
 * @author: Quifar
 * @version: 1.0
 */
@Data
public class Goods {
    private Integer id;
    private String name;
    private BigDecimal price;
    public Goods() {
    }
    public Goods(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
