package com.example.user.service.impl;

import com.example.common.model.User;
import com.example.user.mapper.UserMapper;
import com.example.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author quifar
 */
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public Boolean create(User user) {
        return userMapper.create(user);
    }
}
