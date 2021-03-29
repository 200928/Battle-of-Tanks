package com.Thread.ThreadUse;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 12:55
 * @ Description: com.ThreadUse
 * @ Version: 1.0
 * 使用多线程模拟三个窗口同事售票 100 张
 */
public class SellTicket {
    public static void main(String[] args) {
        // 通过继承实现
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();
        // 通过接口实现
        SellTicket02 sellTicket = new SellTicket02();
        Thread thread01 = new Thread(sellTicket);
        Thread thread02 = new Thread(sellTicket);
        Thread thread03 = new Thread(sellTicket);
        thread01.start();
        thread02.start();
        thread03.start();

    }
}

// 通过继承方式
class SellTicket01 extends Thread {
    private static int ticketNum = 100; // 让多个线程去销售

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("票以售完");
                break;
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
}

// 通过 接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100; // 让多个线程去销售

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("票以售完");
                break;
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
}
