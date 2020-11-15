package com.review.sleepAndStop;

import java.time.LocalDateTime;

/**
 * 测试线程休眠和停止
 * 线程休眠Sleep 不会释放锁
 */
public class TestSleep implements Runnable {
    // 全局Thread状态
    private boolean flag = true;
    public static void main(String[] args) {
        TestSleep testSleepAndStop = new TestSleep();
        new Thread(testSleepAndStop).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 模拟时钟
            LocalDateTime localDateTime = LocalDateTime.now();
            try {
                // 演示一秒钟   sleep的使用   以前出现过说要求客户给钱调优的问题
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(localDateTime);
        }
    }
}
