package com.Thread.State;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 16:47
 * @ Description: com.Thread.State
 * @ Version: 1.0
 * 查看线程的运行状态
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + " 状态 " + t.getState());
        t.start();
        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " 状态 " + t.getState());
            Thread.sleep(1000);
        }
        System.out.println(t.getName() + " 状态 " + t.getState());
    }
}

class T extends Thread {
    @Override
    public void run() {
       for (int i = 0; i < 10; i++) {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("Hi " + i);
       }
    }
}
