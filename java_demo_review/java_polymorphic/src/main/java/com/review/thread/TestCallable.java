package com.review.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @Author: Guo
 * @Date: 2020/11/13 16:24
 * @Name: java_demo_review
 * explain：{@link Callable}
 * 创建多线程的第三种方式 Callable
 */
public class TestCallable implements Callable {
    private String url;
    private String name;
    TestCallable(String url, String name) {
        this.name = name;
        this.url = url;
    }

    @Override
    public Object call() throws Exception {
        DownloadCallable downLoad = new DownloadCallable();
        downLoad.download(url, name);
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://tse1-mm.cn.bing.net/th/id/OIP.fq3C-Dodg9sC0xlCNuB4IQHaLH?w=200&h=300&c=7&o=5&pid=1.7", "1.jpg");
        TestCallable t2 = new TestCallable("https://tse1-mm.cn.bing.net/th/id/OIP.fq3C-Dodg9sC0xlCNuB4IQHaLH?w=200&h=300&c=7&o=5&pid=1.7", "2.jpg");
        TestCallable t3 = new TestCallable("https://tse1-mm.cn.bing.net/th/id/OIP.fq3C-Dodg9sC0xlCNuB4IQHaLH?w=200&h=300&c=7&o=5&pid=1.7", "3.jpg");
        // 创建执行服务
        ExecutorService exe = Executors.newFixedThreadPool(3);
        // 服务
        Future submit = exe.submit(t1);
        Future submit1 = exe.submit(t2);
        Future submit2 = exe.submit(t3);

        // 获取结果
        Object o = submit.get();
        Object o1 = submit2.get();
        Object o2 = submit1.get();
        System.out.println("o = " + o);
        System.out.println("o = " + o1);
        System.out.println("o = " + o2);


        // 关闭当前服务
        exe.shutdownNow();
    }
}


class DownloadCallable {
    public void download(String url, String name) throws IOException {
        System.out.println("name = " + name);
        FileUtils.copyURLToFile(new URL(url), new File(name));
    }
}