package com.yuanqiao.consumer.controller;

import com.yuanqiao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    private String url="http://localhost:8081/user/getUserById";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer id) {

//        return restTemplate.postForObject(url,id,User.class);
        return restTemplate.getForObject(url+"/"+id,User.class);
    }


}
