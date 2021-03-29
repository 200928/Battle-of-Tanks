package com.Homework;

import java.util.Scanner;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 21:11
 * @ Description: com.Homework
 * @ Version: 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        Thread thread = new Thread(t1);
        thread.start();
        T2 t2 = new T2(t1);
        Thread thread1 = new Thread(t2);
        thread1.start();
    }
}

// 随机输出 1-100 数字
class T1 implements Runnable {
    private boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        // 输出 1-100 数字
        while (loop) {
            System.out.println((int) (Math.random() * 100) + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("T1 线程退出");
    }
}

// 输入 Q 上面的线程就会退出
class T2 implements Runnable {
    private T1 a;
    private Scanner scanner = new Scanner(System.in);

    public T2(T1 a) {   // 构造器传入 T1 对象
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            // 接受到用户的输入
            System.out.println("请输入指令(Q)表示退出 : ");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                // 以通知的方式结束 a
                a.setLoop(false);
                break;
            }
        }
        System.out.println("T2 线程退出");
    }
}