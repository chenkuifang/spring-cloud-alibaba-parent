package com.example.user.service;

import com.example.common.model.Points;

/**
 * 积分
 *
 * @author quifar
 */
public interface PointService {

    /**
     * 新增积分
     *
     * @param points
     * @return
     */
    Boolean create(Points points);
}
