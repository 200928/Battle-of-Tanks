package com.mh.TankGame01;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 18:53
 * @ Description: com.mh.TankGame
 * @ Version: 1.0
 */

public class Tank {
    private int x;
    private int y;

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
}
