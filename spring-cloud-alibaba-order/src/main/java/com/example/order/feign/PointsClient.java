package com.example.order.feign;

import com.example.common.model.Points;
import com.example.order.feign.fallback.PointsClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户feign调用
 *
 * @author quifar
 */
@FeignClient(name = "user-service", fallback = PointsClientFallback.class)
public interface PointsClient {

    @PostMapping("/points/create")
    Boolean create(@RequestBody Points points);
}
