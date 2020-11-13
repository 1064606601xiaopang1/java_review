package com.review.test;

/**
 * @Author: Guo
 * @Date: 2020/11/13 10:45
 * @Name: java_demo_review
 * explain：
 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        new ThredDemo(); // 创建一个新线程
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}
