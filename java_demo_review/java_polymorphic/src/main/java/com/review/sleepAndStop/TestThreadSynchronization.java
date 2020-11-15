package com.review.sleepAndStop;

/**
 * synchronized同步  解决多个线程操作同一个对象引起的数据紊乱
 */
public class TestThreadSynchronization implements Runnable {
    private int ticketNum = 10;

    private boolean flag = true;
    @Override
    public void run() {
        // 买票
        while(flag){
            tick();
        }
    }

    private synchronized void tick() {
        if(ticketNum<=0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"_"+ticketNum--);
    }

    public static void main(String[] args) {
        TestThreadSynchronization t = new TestThreadSynchronization();
        new Thread(t,"秦始皇").start();
        new Thread(t,"唐太宗").start();
        new Thread(t,"黄牛贩子").start();
    }
}
