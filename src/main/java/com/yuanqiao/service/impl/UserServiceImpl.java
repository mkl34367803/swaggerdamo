package com.yuanqiao.service.impl;

import com.alibaba.fastjson.JSON;
import com.yuanqiao.dao.UserDao;
import com.yuanqiao.entity.User;
import com.yuanqiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User getUserById(Integer id) {
        User user = userDao.getUserById(id);
        System.out.println("------------------这里打印了吗?------------------------------");
        System.out.println(JSON.toJSONString(user));
        return user;
    }
}
