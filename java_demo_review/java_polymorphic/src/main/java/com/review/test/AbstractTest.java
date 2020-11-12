package com.review.test;

import com.review.entity.*;
import org.junit.Test;

import java.util.Objects;

/**
 * @Author: Guo
 * @Date: 2020/11/12 14:04
 * @Name: java_demo_review
 * explain：抽象类测试方法
 */
public class AbstractTest {
    public static void main(String[] args) {
//        /* 以下是不允许的，会引发错误    抽象方法无法实例化*/
//        AbstractDemo e = new AbstractDemo("George W.", "Houston, TX", 43);
//
//        System.out.println("\n Call mailCheck using Employee reference--");
//        e.mailCheck();

//        Demo02 demo01 = new Demo02("George W.", "Houston, TX", 43, 0.0);
//        demo01.mailCheck();
        test();
    }

    public static void test() {
        AbPerson abPerson = new AbPersonSubclass();
        abPerson.girl();
    }

    @Test
    public void demo() throws IllegalAccessException, InstantiationException {
        Teacher teacher = Teacher.class.newInstance();
        teacher.getId();
        System.out.println("teacher = " + teacher);
    }
}
