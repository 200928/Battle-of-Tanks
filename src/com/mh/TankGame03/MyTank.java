package com.mh.TankGame03;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 18:56
 * @ Description: com.mh.TankGame
 * @ Version: 1.0
 * 自己的坦克
 */
public class MyTank extends Tank {

    // 定义一个 Shut 对象，就是一个线程
    Shot shot = null;

    public MyTank(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {
        // 创建 Shot 对象，根据当前坦克的方向来创建
        switch (getDirect()) {
            case 0: // 向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1: // 向右
                shot = new Shot(getX() + 45, getY() + 30, 1);
                break;
            case 2: // 向下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3: // 向左
                shot = new Shot(getX() - 15, getY() + 30, 3);
        }
        new Thread(shot).start();
    }
}
