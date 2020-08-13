package com.example.user.mapper;

import com.example.common.model.Points;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分
 *
 * @author quifar
 */
@Mapper
public interface PointsMapper {

    Boolean create(Points points);
}
