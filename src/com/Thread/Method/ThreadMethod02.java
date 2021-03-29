package com.Thread.Method;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 16:03
 * @ Description: com.Thread.Method
 * @ Version: 1.0
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyDaemonThread());
        // 如果我们希望当 main 线程结束以后，子线程自动结束
        // 只需将子线程设置为守护线程
        thread.setDaemon(true);
        thread.start();

        for (int i = 1; i <= 5; i++) {
            Thread.sleep(1000);
            System.out.println("我是 main");
        }
    }
}

class MyDaemonThread implements Runnable {

    @Override
    public void run() {
        for (; ; ) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是MyDaemonThread");
        }
    }
}
