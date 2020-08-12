package com.example.common.dto;

import com.example.common.model.Order;
import com.example.common.model.OrderInfo;
import com.example.common.model.User;
import lombok.Data;

import java.util.List;

/**
 * order extends class
 *
 * @author quifar
 */
@Data
public class OrderDTO extends Order {
    private User user;
    private List<OrderInfo> orderInfos;
}
