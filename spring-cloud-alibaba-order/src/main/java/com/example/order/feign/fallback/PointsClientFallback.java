package com.example.order.feign.fallback;

import com.example.common.model.Points;
import com.example.order.feign.PointsClient;
import org.springframework.stereotype.Component;

@Component
public class PointsClientFallback implements PointsClient {
    @Override
    public Boolean create(Points points) {
        return false;
    }
}
