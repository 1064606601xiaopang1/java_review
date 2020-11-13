package com.review.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: Guo
 * @Date: 2020/11/13 13:57
 * @Name: java_demo_review
 * explain：利用多线程下载网络图片
 */
public class Test2ThreadIO extends Thread {
    private String name;
    private String url;

    Test2ThreadIO(String url, String name) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        WebDownloader web = new WebDownloader();
        try {
            web.downloader(url, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test2ThreadIO threadIO = new Test2ThreadIO("https://tse3-mm.cn.bing.net/th/id/OIP.vaQz9M0oX4_vh34CXoRtQAHaK1?w=200&h=293&c=7&o=5&pid=1.7", "1.jpg");
        Test2ThreadIO threadIO2 = new Test2ThreadIO("https://tse3-mm.cn.bing.net/th/id/OIP.vaQz9M0oX4_vh34CXoRtQAHaK1?w=200&h=293&c=7&o=5&pid=1.7", "2.jpg");
        Test2ThreadIO threadIO3 = new Test2ThreadIO("https://tse3-mm.cn.bing.net/th/id/OIP.vaQz9M0oX4_vh34CXoRtQAHaK1?w=200&h=293&c=7&o=5&pid=1.7", "3.jpg");
        threadIO.start();
        threadIO2.start();
        threadIO3.start();
    }
}

class WebDownloader {
    public void downloader(String url, String name) throws IOException {
        System.out.println("name = " + name);
        FileUtils.copyURLToFile(new URL(url), new File(name));
    }
}