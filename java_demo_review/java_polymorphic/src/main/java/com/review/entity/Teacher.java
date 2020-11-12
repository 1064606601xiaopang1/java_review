package com.review.entity;

import lombok.Data;

/**
 * @Author: Guo
 * @Date: 2020/11/12 17:13
 * @Name: java_demo_review
 * explain：
 */
@Data
public class Teacher {
    private Integer id;
    private String name;

    public void Teacher(Integer id, String name) {
        this.id = id;
        this.name = name;
        System.out.println(id + " = " + name);
    }
}
