package com.review.sleepAndStop;

/**
 * 生产者与消费者之间的关系
 * 管程法
 * wait(); 等待
 * notifyAll(); 唤醒
 */
public class TestManagement {
    public static void main(String[] args) {
        buffer buffer = new buffer();
        new products(buffer).start();
        new consumer(buffer).start();

    }
}

/**
 * 生产者
 */
class products extends Thread{
    buffer buffer;
    public products(buffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            buffer.add(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}

/**
 * 消费者
 */
class consumer extends Thread{
    buffer buffer;
    consumer(buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            buffer.remove();
            System.out.println("消费了"+i+"只鸡");
        }
    }
}

class Chicken{
    private int id;
    Chicken(int id){
        this.id = id;
    }
}

class buffer{
    // 容器的大小
    Chicken[] chickens = new Chicken[5];
    // 计数
    int count = 0;

    // 生产者生产
    public synchronized void add(Chicken chicken){
        // 容器满了
        if(count == chickens.length){
            try {
                // 等待消费
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        // 唤醒消费者消费
        this.notifyAll();
    }

    public synchronized Chicken remove(){
        if(count<=0){
            // 等待生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}