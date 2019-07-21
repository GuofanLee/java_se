package com.atguigu.exer;

import java.awt.*;

/**
 * 银行有一个账户，有两个储户分别向同一个账户存3000元，每次存1000，存3次，每次存完打印账户余额
 *
 * @author GuofanLee
 * @date 2019-04-30 22:49
 */
public class AccountTest {

    public static void main(String[] args) {
        Account account = new Account();
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);
        customer1.setName("甲");
        customer2.setName("已");
        customer1.start();
        customer2.start();
    }

}

class Account {

    private double balance = 0;

    public synchronized void deposit(double amt) {
        if (amt > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance += amt;
            System.out.println( Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread {

    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }

}