package com.review.test;

import com.review.entity.Person;
import com.review.entity.Teacher;

/**
 * @Author: Guo
 * @Date: 2020/11/12 17:48
 * @Name: java_demo_review
 * explain：{@link Object} 的公共方法
 */
public class ObjectDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // newInstance创建对象 减少对new的使用
        Object obj = Object.class.newInstance();
        // 1 getClass
        Class<?> aClass = obj.getClass();
        System.out.println("运行时的类型 final 不可修改的 " + aClass);
    }
}
