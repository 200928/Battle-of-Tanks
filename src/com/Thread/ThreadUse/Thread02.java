package com.Thread.ThreadUse;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 11:40
 * @ Description: com.ThreadUse
 * @ Version: 1.0
 * 通过实现 Runnable 接口实现多线程
 */
public class Thread02 {
    public static void main(String[] args) {
       Dog dog = new Dog();
       // 创建一个 Thread 对象，把 dog对象(实现Runnable)，放入 Thread
        // 真正创建了线程
        Thread thread = new Thread(dog);
        thread.start();
        // 模拟并没有创建线程
        ThreadProxy threadProxy = new ThreadProxy(dog);
        threadProxy.start();

    }
}

class Dog implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("汪汪叫：" + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}

// 线程代理类，模拟了一个极简的 Thread类
class ThreadProxy implements Runnable {
    private Runnable target = null;

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();   // 真正实现多线程的方法
    }

    public void start0() {
        run();
    }
}