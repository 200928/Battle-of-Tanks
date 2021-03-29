package com.mh.TankGame03;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 18:53
 * @ Description: com.mh.TankGame
 * @ Version: 1.0
 */

public class Tank {
    private int x;
    private int y;
    // 坦克方向 0上 1右 2下 3右
    private int direct;
    private int speed = 1;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // 向上移动
    public void moveUp() {
        y -= speed;
    }

    // 向右
    public void moveRight() {
        x += speed;
    }

    // 向下
    public void moveDown() {
        y += speed;
    }

    // 向左
    public void moveLeft() {
        x -= speed;
    }

    // 构造器
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
}
