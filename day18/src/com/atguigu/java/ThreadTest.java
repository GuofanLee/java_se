package com.atguigu.java;

/**
 * 创建线程方式二
 *
 * @author GuofanLee
 * @date 2019-04-29 00:26
 */
public class ThreadTest {

    public static void main(String[] args) {
        MThread mThread = new MThread();

        Thread thread1 = new Thread(mThread);
        thread1.start();

        Thread thread2 = new Thread(mThread);
        thread2.start();
    }

}

class MThread implements Runnable {

    /**
     * 输出0-100以内的偶数
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}