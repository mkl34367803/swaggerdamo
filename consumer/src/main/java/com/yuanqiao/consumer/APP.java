package com.yuanqiao.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
//@EnableAutoConfiguration
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class APP {
    @Value("${yuanqiao.name}")
    private static String name;
    @Value("${yuanqiao.age}")
    private static String age;
    public static void main(String[] args) {
        System.out.println(name);
        System.out.println("----------------------------------");
        System.out.println(age);
        SpringApplication.run(APP.class,args);
    }
}
