package com.yuanqiao.dao;

import com.yuanqiao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface UserDao {

    public User getUserById(Integer id);
}
