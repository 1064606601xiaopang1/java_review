package com.review.entity;

/**
 * @Author: Guo
 * @Date: 2020/11/12 14:18
 * @Name: java_demo_review
 * explain：
 */
public class AbPersonSubclass extends AbPerson {
    private int id;
    private String name;

    @Override
    public void girl() {
        display();
        System.out.println("这是Person类的子类");
    }

    public AbPersonSubclass() {
        System.out.println("这是构造器");
    }

    void display() {
        System.out.println(id + " = " + name);
    }
}
