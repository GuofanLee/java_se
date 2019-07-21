package com.atguigu.java;

/**
 * 创建三个窗口买票，总票数100张
 * 存在线程安全问题
 *
 * @author GuofanLee
 * @date 2019-04-30 17:42
 */
public class TicketTest {

    public static void main(String[] args) throws InterruptedException {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }

}

class Window extends Thread {

    private static int ticket = 100;

    public void run() {
        while (true) {
            if (ticket > 0) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + ":买票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

}