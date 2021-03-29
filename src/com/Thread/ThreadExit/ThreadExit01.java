package com.Thread.ThreadExit;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 14:04
 * @ Description: com.Thread.ThreadExit
 * @ Version: 1.0
 */
public class ThreadExit01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        System.out.println("主线程休眠 10s");
        Thread.sleep(10000);
        t.setLoop(false);

    }
}

class T extends Thread {
    private int num = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T运行中......" + (++num));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
