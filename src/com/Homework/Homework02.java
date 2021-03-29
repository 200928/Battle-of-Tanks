package com.Homework;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 21:47
 * @ Description: com.Homework
 * @ Version: 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        T t = new T();
        Thread thread1 = new Thread(t);
        thread1.setName("T1");
        Thread thread2 = new Thread(t);
        thread2.setName("T2");

        thread1.start();
        thread2.start();

    }
}

// 取款线程
class T implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足！！！");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取出 1000, 当前余额 : " + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
