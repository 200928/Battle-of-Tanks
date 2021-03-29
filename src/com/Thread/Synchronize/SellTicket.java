package com.Thread.Synchronize;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 12:55
 * @ Description: com.Thread.Synchronize
 * @ Version: 1.0
 * 使用多线程模拟三个窗口同事售票 100 张
 */
public class SellTicket {
    public static void main(String[] args) {
        // 通过继承实现
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();
        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();
        // 通过接口实现
//        SellTicket02 sellTicket = new SellTicket02();
//        Thread thread01 = new Thread(sellTicket);
//        Thread thread02 = new Thread(sellTicket);
//        Thread thread03 = new Thread(sellTicket);
//        thread01.start();
//        thread02.start();
//        thread03.start();

    }
}


class SellTicket01 extends Thread {
    private static int ticketNum = 100; // 让多个线程去销售
    private boolean loop = true;
    static Object object = new Object();

    public void sell() {  // 同步方法，在同一时刻，只能有一个线程来执行该方法
        synchronized (object) {
            if (ticketNum <= 0) {
                loop = false;
                System.out.println("票以售完");
                return;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口：" + Thread.currentThread().getName() + " 售出一张票" +
                    " 剩余票数：" + (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}


class SellTicket02 implements Runnable {
    private static int ticketNum = 100; // 让多个线程去销售
    private boolean loop = true;
    Object object = new Object();

    // 同步方法实现加锁
    // 这时锁在 this 对象
    // 也可以在代码块写 synchronized ，这是同步代码块
    public /*synchronized*/ void sell() {  // 同步方法，在同一时刻，只能有一个线程来执行该方法
        synchronized (/*this*/ object) {    // 写this或object都可以
            if (ticketNum <= 0) {
                loop = false;
                System.out.println("票以售完");
                return;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口：" + Thread.currentThread().getName() + " 售出一张票" +
                    " 剩余票数：" + (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
