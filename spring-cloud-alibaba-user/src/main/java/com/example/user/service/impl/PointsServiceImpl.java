package com.example.user.service.impl;

import com.example.common.model.Points;
import com.example.user.mapper.PointsMapper;
import com.example.user.service.PointService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author quifar
 */
@AllArgsConstructor
@Service
public class PointsServiceImpl implements PointService {

    private PointsMapper pointsMapper;

    @Override
    public Boolean create(Points points) {

        // 其中一个服务出现异常，事务无法全局回滚
        /*if (points != null) {
            throw new RuntimeException();
        }*/
        return pointsMapper.create(points);
    }
}
