package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select * from user where openid=#{openid}")
    User getByOpenid(String openid);

    void insert(User user);
    @Select("select * from user where user.id=#{userId}")
    User getById(Long userId);

    @Select("select * from user where openid=#{userId}")
    User getByid(Long userId);

    Integer countByMap(Map map);
}
