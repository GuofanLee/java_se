package com.atguigu.java4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口创建线程
 *
 * @author GuofanLee
 * @date 2019-05-01 15:36
 */
public class CallalbeTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        Thread thread = new Thread(futureTask);
        thread.start();
        Object value = futureTask.get();
        System.out.println("100以内偶数的和：" + value);
    }

}

class NumThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}