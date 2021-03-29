package com.Thread.ThreadUse;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 9:55
 * @ Description: com.ThreadUse
 * @ Version: 1.0
 * 演示通过继承 Thread 类创建线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        // 创建cat对象，可以当成线程使用
        Cat cat = new Cat();
        cat.start();    // 启动线程 -> 最终会执行 Cat 的run方法
        // 说明：当 main 线程启动一个子线程 Thread-0 主线程不会阻塞，会继续执行
        // 主线程和子线程交替执行
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i = " + i);
            Thread.sleep(1000);
        }
    }
}

/**
 * 当一个类继承了 Thread 类，该类就可以当做线程使用
 * 重写 run 方法，写上自己的业务代码
 * run 方法来自 Thread 类实现了Runnable 接口的 run 方法
 *
 */
/*
@Override
public void run() {
    if (target != null) {
        target.run();
    }
}
 */
class Cat extends Thread {
    private int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵喵" + (++times) + "，线程名称：" + Thread.currentThread().getName());
            // 让该进程休眠 1 秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 80) {
                 break;
            }
        }
    }
}
