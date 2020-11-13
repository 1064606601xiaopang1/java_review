package com.review.thread;

/**
 * @Author: Guo
 * @Date: 2020/11/13 13:54
 * @Name: java_demo_review
 * explain：
 */
public class TestThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("线程执行i = " + i);
        }
    }

    public static void main(String[] args) {
        // 创建线程
        TestThread testThread = new TestThread();
        // 线程启动
        testThread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("当前执行：" + i);
        }
    }
}
