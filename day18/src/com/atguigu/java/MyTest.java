package com.atguigu.java;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-01 00:41
 */
public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        Windows w = new Windows();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

}

class TicketDao {
    private static int ticket = 100;

    public static int getTicket() {
        return ticket;
    }

    public static void setTicket(int t) {
        ticket = t;
    }

}

class TicketService {

    private static TicketService ticketService = new TicketService();

    private TicketService() {}

    public static TicketService getInstance() {
        return ticketService;
    }

    public synchronized void getTicket() {
        int ticket = TicketDao.getTicket();
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            TicketDao.setTicket(ticket - 1);
        } else {
            System.out.println(Thread.currentThread().getName() + "票卖完了");
        }
    }

}

class Windows implements Runnable {

    private TicketService ticketService = TicketService.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < 120; i++) {
            ticketService.getTicket();
        }
    }
}
