package com.review.sleepAndStop;

public class TestLock {
    public static void main(String[] args) {
        Makeup makeup = new Makeup(0,"白雪公主");
        Makeup makeup1 = new Makeup(1,"灰姑凉");

        new Thread(makeup).start();
        new Thread(makeup1).start();
    }
}

// 口红
class Lipstick{

}
// 镜子
class Mirror{

}
class Makeup implements Runnable{

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    private int choice;
    private String name;

    Makeup(int choice,String name){
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 造成死锁  互相需要对方占有的资源
     * @throws InterruptedException
     */
    void makeup() throws InterruptedException {
        if(choice==0){
            synchronized (lipstick){
                System.out.println(this.name+"获得了口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(this.name+"获得了镜子的锁");
                }
            }
        }else{
            synchronized (mirror){
                System.out.println(this.name+"获得了镜子的锁");
                Thread.sleep(1000);
                synchronized (lipstick){
                    System.out.println(this.name+"获得了口红的锁");
                }
            }
        }
    }
}
