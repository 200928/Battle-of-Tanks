package com.mh.TankGame_0_1;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/29 - 19:14
 * @ Description: com.mh.TankGame_0_1
 * @ Version: 1.0
 * 坦克基本属性
 */
public class Tank {
    private int x;
    private int y;
    private int direct = 0;     // 坦克的方向，0上 1右 2下 3左
    private int speed = 2;      // 坦克速度，默认 2

    public void moveUP() {
        y -= speed;
    }
    public void moveRight() {
        x += speed;
    }
    public void moveDown() {
        y += speed;
    }
    public void moveLeft() {
        x -= speed;
    }

    // 提供坦克的坐标
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
