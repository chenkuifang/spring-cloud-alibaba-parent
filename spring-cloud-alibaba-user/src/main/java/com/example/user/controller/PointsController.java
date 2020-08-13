package com.example.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.common.model.Points;
import com.example.user.service.PointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 积分控制器
 *
 * @author Quifar
 * @version 1.0
 */
@Slf4j
@RequestMapping("/points")
@RestController
public class PointsController {

    @Autowired
    private PointService pointService;

    @PostMapping("/create")
    public Boolean create(@RequestBody Points points) {
        log.info("新增积分记录，上下文：{}", JSONObject.toJSONString(points));
        try {
            return pointService.create(points);
        } catch (Exception e) {
            log.error("新增用户积分失败。上下文{}", JSONObject.toJSONString(points));
            return false;
        }
    }
}
