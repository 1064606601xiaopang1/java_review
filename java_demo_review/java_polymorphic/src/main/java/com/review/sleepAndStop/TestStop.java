package com.review.sleepAndStop;

import java.time.LocalDateTime;

/**
 * 线程停止stop() 不建议使用  推荐使用一个标志位解决
 */
public class TestStop implements Runnable {
    private boolean flag = true;
    private int i = 0;
    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        // 启动线程
        new Thread(testStop).start();
    }

    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(1000);
                i++;
                System.out.println(LocalDateTime.now());
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==10){
                flagStatus();
            }
        }
    }

    // 状态更改
    public void flagStatus(){
        flag = false;
    }
}
