package com.review.entity;

/**
 * @Author: Guo
 * @Date: 2020/11/12 11:15
 * @Name: java_demo_review
 * explain：
 */
public class Children extends Person {
    @Override
    void china() {
        System.out.println("Children中国男孩");
    }

    void girl() {
        System.out.println("Children中国女孩");
    }
}
