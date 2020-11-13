package com.review.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: Guo
 * @Date: 2020/11/13 14:45
 * @Name: java_demo_review
 * explain：
 */
public class TestRunnable implements Runnable {
    private String url;
    private String name;

    TestRunnable(String url, String name) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        DownLoad downLoad = new DownLoad();
        try {
            downLoad.downloader(url, name);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestRunnable t1 = new TestRunnable("https://tse1-mm.cn.bing.net/th/id/OIP.fq3C-Dodg9sC0xlCNuB4IQHaLH?w=200&h=300&c=7&o=5&pid=1.7", "1.jpg");
        TestRunnable t2 = new TestRunnable("https://tse1-mm.cn.bing.net/th/id/OIP.fq3C-Dodg9sC0xlCNuB4IQHaLH?w=200&h=300&c=7&o=5&pid=1.7", "2.jpg");
        TestRunnable t3 = new TestRunnable("https://tse1-mm.cn.bing.net/th/id/OIP.fq3C-Dodg9sC0xlCNuB4IQHaLH?w=200&h=300&c=7&o=5&pid=1.7", "3.jpg");

        // 执行Runnable方法需要new Thread
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

/**
 * 下载
 */
class DownLoad {
    public void downloader(String url, String name) throws MalformedURLException {
        try {
            System.out.println("name = " + name);
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}