package com.review.entity;

/**
 * @Author: Guo
 * @Date: 2020/11/12 11:37
 * @Name: java_demo_review
 * explain：
 */
public class Demo01 {
    public static void main(String[] args) {
        A a = new A();
        a.show();
        B b = new B();
        b.show();
        C c = new C();
        c.show();
        c.demo();
    }
}

class A {
    public void demo() {
        System.out.println("demo");
    }

    public void show() {
        show2();
    }

    public void show2() {
        System.out.println("A");
    }
}

class B extends A {
    @Override
    public void show2() {
        System.out.println("B");
    }
}

class C extends B {
    @Override
    public void demo() {
        super.demo();
        System.out.println("B -demo");
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void show2() {
        System.out.println("C");
    }
}
