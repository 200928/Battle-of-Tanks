package com.mh.TankGame01;

import javax.swing.*;
import java.awt.*;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 18:58
 * @ Description: com.mh.TankGame
 * @ Version: 1.0
 * 坦克大战的绘图区
 */
public class MyPanel extends JPanel {
    // 定义我的坦克
    MyTank mytank = null;

    public MyPanel() {
        // 初始化自己的坦克
        mytank = new MyTank(100, 100);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("被调用");
        g.fillRect(0, 0, 1000, 750);
        drawTank(mytank.getX(), mytank.getY(), g, 0, 0);
//        g.drawOval(10,10,200,200);
    }

    /**
     *
     * @param x 坦克左上角横坐标
     * @param y 坦克左上角纵坐标
     * @param g 画笔
     * @param direct 方向
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        // 判断坦克类型
        switch (type) {
            case 0: // 我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 敌人坦克
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克方向绘制坦克
        switch (direct) {
            case 0: // 向上
                g.fill3DRect(x, y, 10, 60, false);  // 左边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);    // 身体
                g.fill3DRect(x + 30, y, 10, 60, false); // 右轮子
                g.drawOval(x + 10, y + 20, 18, 18); // 炮台
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            default:
                System.out.println("暂时不处理");
        }

    }
}
