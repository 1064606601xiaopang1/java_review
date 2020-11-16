package com.review;

import org.junit.Test;

/**
 * @Author: Guo
 * @Date: 2020/11/16 17:27
 * @Name: java_demo_review
 * explain：&与 &&
 */
public class TestAndDemo {
    final String a = "测试数据";
    static String name;

    public static void main(String[] args) {
        String userName = "";
        if (name != null && userName.equals("")) {
            System.out.println("ok");
        } else {
            System.out.println("error");
        }
    }

    @Test
    public void test1(){
        System.out.println(a);
    }
}
