package com.mh.TankGame_0_1;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/29 - 22:26
 * @ Description: com.mh.TankGame_0_1
 * @ Version: 1.0
 */
public class Shot implements Runnable {
    private int x;  // 子弹的横坐标
    private int y;  // 子弹的纵坐标
    private int direct; // 子弹的运行方向
    private int speed = 2;  // 子弹的速度默认为 2
    private boolean isLive = true;  // 子弹的状态(死活)

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirect() {
        return direct;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean getLive() {
        return isLive;
    }

    @Override
    public void run() {
        while (isLive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 根据子弹方向进行运动
            switch (direct) {
                case 0: // 向上
                    y -= speed;
                    break;
                case 1: // 向右
                    x += speed;
                    break;
                case 2: // 向下
                    y += speed;
                    break;
                case 3: // 向左
                    x -= speed;
            }
//            System.out.println("x=" + x + ",y=" + y);
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
//                System.out.println("子弹退出！！！");
                isLive = false;
                break;
            }
        }
    }
}
