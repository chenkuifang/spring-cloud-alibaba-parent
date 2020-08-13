package com.example.user.mapper;

import com.example.common.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author quifar
 */
@Mapper
public interface UserMapper {

    Boolean create(User user);
}
