package com.review.sleepAndStop;

/**
 * 生产与消费：
 * 信号法
 */
public class TestTestManagement2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new perform(tv).start();
        new audience(tv).start();
    }
}

/**
 * 表演节目
 */
class perform extends Thread{
    TV tv;
    perform(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                tv.play("快乐大本营"+i);
            }else{
                tv.play("舌尖上的美味"+i);
            }
        }
    }
}

/**
 * 观众观看
 */
class audience extends Thread{
    TV tv;
    audience(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

class TV{
    // flag = true 观众等待
    // flag = false 演员等待
    private boolean flag = true;
    private String name;
    // 表演
    public synchronized void play(String name){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了："+name);
        this.notifyAll();
        this.name = name;
        this.flag = !flag;
    }

    // 观看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了："+name);
        this.notifyAll();
        this.name = name;
        this.flag = !flag;
    }
}
