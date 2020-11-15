package com.review.sleepAndStop;

/**
 * 守护线程和用户线程
 * 守护线程：gc
 * 用户线程: new  只需要保证用户线程正常执行
 */
public class TestDaemon {
    public static void main(String[] args) {
        Your your = new Your();
        lord lord = new lord();
        Thread thread = new Thread(lord);
        // 默认为false用户线程  true守护线程
        thread.setDaemon(true);

        Thread thread1 = new Thread(your);

        thread.start();
        thread1.start();
    }
}
// 守护程序
class lord implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("愿上帝保佑着你");
        }
    }
}

// 用户程序
class Your implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            System.out.println("开心的活着！"+i);
        }
    }
}
