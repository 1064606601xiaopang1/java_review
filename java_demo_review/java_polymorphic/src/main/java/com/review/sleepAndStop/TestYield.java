package com.review.sleepAndStop;

/**
 * Thread.yield() 礼让   不保证成功
 */
public class TestYield implements Runnable{
    public static void main(String[] args) {
        TestYield testYield = new TestYield();

        new Thread(testYield,"a").start();
        new Thread(testYield,"b").start();
    }

    @Override
    public void run() {
        System.out.println("开始执行了"+Thread.currentThread().getName());
        Thread.yield();
        System.out.println("执行完了哦"+Thread.currentThread().getName());
    }
}
