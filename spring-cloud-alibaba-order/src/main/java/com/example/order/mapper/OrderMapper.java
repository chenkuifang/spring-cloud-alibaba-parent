package com.example.order.mapper;

import com.example.common.dto.OrderDTO;
import com.example.common.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author quifar
 */
@Mapper
public interface OrderMapper {

    List<OrderDTO> list();

    Boolean create(Order order);
}
