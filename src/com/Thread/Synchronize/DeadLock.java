package com.Thread.Synchronize;

import javax.sound.midi.Soundbank;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 20:06
 * @ Description: com.Thread.Synchronize
 * @ Version: 1.0
 * 模拟死锁
 */
public class DeadLock {
    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo(true);
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(false);
        deadLockDemo.start();
        deadLockDemo1.start();
    }
}

class DeadLockDemo extends Thread {
    private boolean flag;
    static Object o1 = new Object();
    static Object o2 = new Object();

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            if (flag) {
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入了 1 ");
                    synchronized (o2) {
                        System.out.println(Thread.currentThread().getName() + " 进入了 2 ");
                    }
                }
            } else {
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " 进入了 3 ");
                    synchronized (o1) {
                        System.out.println(Thread.currentThread().getName() + " 进入了 4 ");
                    }
                }
            }
        }
    }
}
