package com.atguigu.test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-03 17:08
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        ReadWriteLockDemo rwd = new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rwd.set((int) (Math.random() * 101));
            }
        }, "写线程").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rwd.get();
                }
            }, "读线程" + i).start();
        }

    }

}

class ReadWriteLockDemo {

    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":" + number);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void set(int number) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":写");
            this.number = number;
        } finally {
            lock.writeLock().unlock();
        }
    }

}