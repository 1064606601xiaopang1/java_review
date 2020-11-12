package com.review.test;

import com.review.entity.Children;
import com.review.entity.Person;
import com.review.entity.USA;
import org.junit.Test;

/**
 * @Author: Guo
 * @Date: 2020/11/12 11:25
 * @Name: java_demo_review
 * explain：测试方法
 */
public class Polymorphic {
    public static void main(String[] args) {
        Person p = new Children();
        Children children = new Children();
    }

    public static void test() {
    }


    @Test
    public void test01() {
        USA.test();
    }
}
