package com.mh.TankGame_0_1;

import java.util.Vector;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/29 - 19:14
 * @ Description: com.mh.TankGame_0_1
 * @ Version: 1.0
 * 自己的坦克
 */
public class OurTank extends Tank {
    int type = 0;   // 表示是我方坦克
    Shot shot = null;   // 定义一颗子弹
    Vector<Shot> shots = new Vector<>();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    // 初始化坦克的位置
    public OurTank(int x, int y) {
        super(x, y);
    }

    // 发射子弹的函数
    public void shotEnemyTank() {
        if (shots.size() > 1000) {
            return;
        }
        switch (getDirect()) {
            case 0:
                shot = new Shot(getX() + 20, getY(), getDirect());
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 20, getDirect());
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, getDirect());
                break;
            case 3:
                shot = new Shot(getX(), getY() + 20, getDirect());
        }
        shots.add(shot);
        new Thread(shot).start();
    }
}
