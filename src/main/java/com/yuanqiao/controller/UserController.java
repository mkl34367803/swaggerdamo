package com.yuanqiao.controller;

import com.yuanqiao.entity.User;
import com.yuanqiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * http://localhost:8080/user/getUser?username=zhangsan&password=123456
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/user/getUser")
    public String getUser(String username, String password, HttpServletRequest request,Integer age){
        return username+password;
    }

    /**
     * http://localhost:8080/user/getUserRestFully/zhangsan/123
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/user/getUserRestFully/{password}/{username}")
    public String getUserRestFully(@PathVariable("username") String username,@PathVariable("password") String password){
        return username+password;
    }


    @GetMapping("/user/getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

}
