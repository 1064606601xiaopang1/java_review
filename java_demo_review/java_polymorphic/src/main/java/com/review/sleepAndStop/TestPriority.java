package com.review.sleepAndStop;

/**
 * 线程优先级 Priority 1-10
 */
public class TestPriority {
    public static void main(String[] args) {
        // 主线程
        System.out.println(Thread.currentThread().getPriority()+"__"+Thread.currentThread().getName());

        myPriority myPriority = new myPriority();

        Thread thread = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);
        Thread thread4 = new Thread(myPriority);

        thread.start();

        thread2.setPriority(6);
        thread2.start();

        thread3.setPriority(1);
        thread3.start();

        thread4.setPriority(Thread.MAX_PRIORITY);
        thread4.start();

    }
}

class myPriority implements Runnable{

    @Override
    public void run() {
        // 获取当前线程的优先级和名字
        System.out.println(Thread.currentThread().getPriority()+"__"+Thread.currentThread().getName());
    }
}
