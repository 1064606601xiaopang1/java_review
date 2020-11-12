package com.review.entity;

/**
 * @Author: Guo
 * @Date: 2020/11/12 11:28
 * @Name: java_demo_review
 * explain：
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Children();
        person.china();
        Person person1 = person;
        Children children = (Children) person1;
        children.girl();
    }
}
