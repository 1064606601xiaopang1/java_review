package com.review.sleepAndStop;

/**
 * 线程的状态
 */
public class TestState {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("逻辑执行完毕");
        });

        Thread.State state = thread.getState();
        System.out.println("state = " + state);

        thread.start();
        state = thread.getState();
        System.out.println("state = " + state);

        while (state!=Thread.State.TERMINATED){
            state = thread.getState();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("while  state = " + state);
        }
//        thread.start();   // 销毁的线程不可以在次start();
    }
}
