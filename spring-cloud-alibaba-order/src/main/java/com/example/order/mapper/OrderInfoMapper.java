package com.example.order.mapper;

import com.example.common.model.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author quifar
 */
@Mapper
public interface OrderInfoMapper {

    Boolean createBatch(List<OrderInfo> infos);
}
