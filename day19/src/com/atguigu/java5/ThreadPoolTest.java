package com.atguigu.java5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池
 *
 * @author GuofanLee
 * @date 2019-05-01 16:05
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) service;

        service.execute(new NumberThread1());  //适合使用Runnable
        service.execute(new NumberThread2());  //适合使用Runnable
//        service.submit();   //适合使用Callable和Runnable
        service.shutdown(); //关闭连接池


    }

}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
