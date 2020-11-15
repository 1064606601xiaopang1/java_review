package com.review.sleepAndStop;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class TestThreadPool {

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 执行
        executorService.execute(new myThread());
        executorService.execute(new myThread());
        executorService.execute(new myThread());

        // 关闭连接池
        executorService.shutdown();
    }

}

class myThread implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行了");
    }
}
