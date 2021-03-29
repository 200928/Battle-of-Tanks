package com.Thread.Method;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 15:25
 * @ Description: com.Thread.Method
 * @ Version: 1.0
 * 测试礼让包子
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        // 主线程吃包子
        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程（小弟）吃了 " + i + " 个包子");
            // 主线程吃 5 个包子就让老大吃完 20 个然后在吃
            if (i == 5) {
                System.out.println("主线程（小弟）让 包子给 老大吃");
                // join 线程插队
                t.join();
                // yield 礼让
//                Thread.yield();
                System.out.println("老大吃完了，接下来主线程（小弟）吃");

            }
        }
    }
}

class T extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程（老大）吃了 " + i + " 个包子");
        }
    }
}
