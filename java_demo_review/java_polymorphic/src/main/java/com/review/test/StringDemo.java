package com.review.test;

import org.junit.Test;

/**
 * @Author: Guo
 * @Date: 2020/11/12 17:21
 * @Name: java_demo_review
 * explain：
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "a" + "b";
        System.out.println(s1 == s2);  // true
        String s3 = "a";
        String s4 = "b";
        String s5 = s3 + s4;
        System.out.println(s5 == s2);
        System.out.println(s5.equals(s2));
    }


    @Test
    public void test() {
        String s1 = new StringBuilder().append("aa").append("aa").toString();
        String s2 = s1.intern();
        System.out.print(s1 == s2);
    }


    @Test
    public void test01() throws IllegalAccessException, InstantiationException {
        Object o = Object.class.newInstance();
        Class<?> aClass = o.getClass();
        o.notify();
    }
}
