package com.yuanqiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 使用lombok可以减少些构建方法,getter,setter方法.you must implements Serializable
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors
public class TestType implements Serializable{
    private String name;
    private String gender;
    private Integer age;

}
