package com.atguigu.test;

/**
 * 三个线程通信
 *
 * @author GuofanLee
 * @date 2019-05-03 01:34
 */
public class MyThreadTest2 {

    public static void main(String[] args) {

        Printer printer = new Printer();

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

class Printer {

    private int flag = 1;

    public synchronized void print1(int i) {
        while (flag != 1) {
            try {
                wait();
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
        notifyAll();
    }

    public synchronized void print2(int i) {
        while (flag != 2) {
            try {
                wait();
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
        notifyAll();
    }

    public synchronized void print3(int i) {
        while (flag != 3) {
            try {
                wait();
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
        notifyAll();
    }
}
