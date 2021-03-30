package com.mh.TankGame_0_1;

import java.util.Random;
import java.util.Vector;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/29 - 20:58
 * @ Description: com.mh.TankGame_0_1
 * @ Version: 1.0
 */
public class EnemyTank extends Tank implements Runnable {
    int type = 1;   // 表示敌方坦克
    boolean isLive = true;  // 坦克的状态，默认是活的
    Vector<Shot> shots = new Vector<>();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            // 判断坦克的子弹还有没有
            if (isLive && shots.size() < 100) {  // 没有则创建
                Shot shot = null;
                switch (getDirect()) {
                    case 0:
                        shot = new Shot(getX() + 20, getY(), getDirect());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        shot = new Shot(getX() + 60, getY() + 20, getDirect());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        shot = new Shot(getX() + 20, getY() + 60, getDirect());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        shot = new Shot(getX(), getY() + 20, getDirect());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
                new Thread(shot).start();
                shots.add(shot);
            }

            // 根据坦克的方向移动
            switch (getDirect()) {
                case 0:
                    // 随机走 [2, 6]
                    int move = new Random().nextInt(5) + 5;
                    for (int i = 0; i < move; i++) {
                        if (getY() > 0) {
                            moveUP();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    // 随机走 [2, 6]
                    move = new Random().nextInt(5) + 5;
                    for (int i = 0; i < move; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    // 随机走 [2, 6]
                    move = new Random().nextInt(5) + 5;
                    for (int i = 0; i < move; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    // 随机走 [2, 6]
                    move = new Random().nextInt(5) + 5;
                    for (int i = 0; i < move; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            // 随机改变坦克方向
            setDirect((int) (Math.random() * 4));
            if (!isLive()) {
                break;
            }
        }
    }
}
