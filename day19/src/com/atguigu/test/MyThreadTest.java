package com.atguigu.test;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-03 01:11
 */
public class MyThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(){
            public void run() {
                setName("线程1");
                for (int i = 0; i < 100; i++) {
                    try {
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":" +i);
                }
            }
        };

        myThread.setDaemon(true);
        myThread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程2");
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" +i);
                }
            }
        }).start();

    }

}
