package com.mh.TankGame03;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 22:23
 * @ Description: com.mh.TankGame03
 * @ Version: 1.0
 * 射击子弹
 */
public class Shot implements Runnable {
    int x;                  // 子弹x坐标
    int y;                  // 子弹y坐标
    int direct = 0;         // 子弹方向
    int speed = 2;          // 子弹速度
    boolean isLive = true;  // 子弹是否存活

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() { // 射击
        while (isLive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 根据方向移动子弹
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
                    break;
            }
            System.out.println("X = " + x + ", Y = " + y);  // 测试

            // 撞到墙了要销毁该子弹
            // 或者是当射到敌人的时候也要销毁s
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                isLive = false;
                break;
            }
        }
    }
}
