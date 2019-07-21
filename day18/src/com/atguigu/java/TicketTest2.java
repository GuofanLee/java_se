package com.atguigu.java;

/**
 * 创建三个窗口买票，总票数100张
 * 存在线程安全问题
 *
 * @author GuofanLee
 * @date 2019-04-30 18:32
 */
public class TicketTest2 {

    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Thread thread1 = new Thread(w1);
        Thread thread2 = new Thread(w1);
        Thread thread3 = new Thread(w1);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Window1 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}