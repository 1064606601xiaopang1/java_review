package com.review.thread;

/**
 * @Author: Guo
 * @Date: 2020/11/13 15:47
 * @Name: java_demo_review
 * explain：实现龟兔赛跑
 */
public class Test03Thread implements Runnable {
    private static String winnerName;

    @Override
    public void run() {
        for (int i = 0; i <= 101; i++) {
            System.out.println(Thread.currentThread().getName() + "跑到了---->第" + i + "米");
            // 当线程为兔子并且可以被10整除的时候休息10毫秒
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean winner = winner(i);
            if (winner) {
                break;
            }
        }
    }

    private boolean winner(int max) {
        if (winnerName != null) {
            return true;
        } else {
            if (max >= 101) {
                winnerName = Thread.currentThread().getName();
                System.out.println("winner is " + winnerName);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test03Thread test03Thread = new Test03Thread();
        new Thread(test03Thread, "兔子").start();
        new Thread(test03Thread, "乌龟").start();
    }
}
