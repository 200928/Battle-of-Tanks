package com.Thread.ThreadUse;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 12:28
 * @ Description: com.ThreadUse
 * @ Version: 1.0
 * main 函数启动两个子线程
 */
public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}

class T1 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        do {
            System.out.println("T1:Hello,World " + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (count != 80);
    }
}


class T2 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        do {
            System.out.println("T2:Hello,World " + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (count != 80);
    }
}

