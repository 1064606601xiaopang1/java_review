package com.review.test;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Guo
 * @Date: 2020/11/13 10:16
 * @Name: java_demo_review
 * explain：
 */
public class ThredDemo implements Runnable {
    Thread t;

    ThredDemo() {
        // 创建第二个新线程
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
        t.start(); // 开始线程
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                // 暂停线程
                Thread.sleep(50);
            }
        } catch (Exception e) {
            System.out.println("异常了");
        }
        System.out.println("线程1执行完了");

    }
}