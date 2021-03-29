package com.mh.TankGame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.invoke.MethodHandle;
import java.util.Vector;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 18:58
 * @ Description: com.mh.TankGame
 * @ Version: 1.0
 * 坦克大战的绘图区
 */
public class MyPanel extends JPanel implements KeyListener {
    // 定义我的坦克
    MyTank mytank = null;
    // 定义敌人坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 5;

    public MyPanel() {
        // 初始化自己的坦克
        mytank = new MyTank(100, 100);
        mytank.setSpeed(5);
        // 初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank((100*(i+1)), 0));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        drawTank(mytank.getX(), mytank.getY(), g, mytank.getDirect(), 0);
        // 初始化敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank tmp = enemyTanks.get(i);
            tmp.setDirect(2);
            drawTank(tmp.getX(), tmp.getY(), g, tmp.getDirect(), 1);
        }
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
                g.setColor(Color.yellow);
                break;
            case 1: // 敌人坦克
                g.setColor(Color.cyan);
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
            case 1: // 向右
                x -= 15;
                y += 10;
                g.fill3DRect(x, y, 60, 10, false);  // 上边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);    // 身体
                g.fill3DRect(x, y + 30, 60, 10, false); // 下边轮子
                g.drawOval(x + 20, y + 10, 18, 18);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: // 向下
                g.fill3DRect(x, y, 10, 60, false);  // 左边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);    // 身体
                g.fill3DRect(x + 30, y, 10, 60, false); // 右轮子
                g.drawOval(x + 10, y + 20, 18, 18); // 炮台
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: // 向左
                x -= 15;
                y += 10;
                g.fill3DRect(x, y, 60, 10, false);  // 上边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);    // 身体
                g.fill3DRect(x, y + 30, 60, 10, false); // 下边轮子
                g.drawOval(x + 20, y + 10, 18, 18);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时不处理");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            mytank.setDirect(0);
            mytank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            mytank.setDirect(1);
            mytank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            mytank.setDirect(2);
            mytank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            mytank.setDirect(3);
            mytank.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
