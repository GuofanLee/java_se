package com.atguigu.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-03 13:56
 */
public class MyThreadTest3 {

    public static void main(String[] args) {
        Printer2 printer = new Printer2();

        new Thread() {
            public void run() {
                setName("线程1");
                for (int i = 0; i < 100; i++) {
                    printer.print1(i);
                }
            }
        }.start();

        new Thread() {
            public void run() {
                setName("线程2");
                for (int i = 0; i < 100; i++) {
                    printer.print2(i);
                }
            }
        }.start();

        new Thread() {
            public void run() {
                setName("线程3");
                for (int i = 0; i < 100; i++) {
                    printer.print3(i);
                }
            }
        }.start();
    }

}

class Printer2 {

    private ReentrantLock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    private int flag = 1;

    public void print1(int i) {
        lock.lock();
        try {
            if (flag != 1) {
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName() + "-" + i + ":");
            System.out.print("a");
            System.out.print("a");
            System.out.print("a");
            System.out.println();
            flag = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print2(int i) {
        lock.lock();
        try {
            if (flag != 2) {
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName() + "-" + i + ":");
            System.out.print("b");
            System.out.print("b");
            System.out.print("b");
            System.out.println();
            flag = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }

    }

    public void print3(int i) {
        lock.lock();
        try {
            if (flag != 3) {
                try {
                    c3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName() + "-" + i + ":");
            System.out.print("c");
            System.out.print("c");
            System.out.print("c");
            System.out.println();
            flag = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }

    }
}
