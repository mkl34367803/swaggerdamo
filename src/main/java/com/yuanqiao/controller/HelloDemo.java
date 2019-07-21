package com.yuanqiao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDemo {
    @GetMapping(value="/sayHello")
    public String sayHello(){
        return "hello yuanqiao";
    }

    @GetMapping("/getUser")
    public String getUser(){
        return "zhangsan";
    }
}
