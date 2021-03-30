package com.mh.TankGame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 18:58
 * @ Description: com.mh.TankGame
 * @ Version: 1.0
 * 坦克大战的绘图区
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
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
            EnemyTank tmp = new EnemyTank((100*(i+1)), 0);
            tmp.setDirect(2);
            Shot shot = new Shot(tmp.getX() + 20, tmp.getY() + 60, tmp.getDirect());
            tmp.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(tmp);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
//=================================画自己坦克====================================
        // 画自己坦克
        drawTank(mytank.getX(), mytank.getY(), g, mytank.getDirect(), 0);
        // 子弹
        if (mytank.shot != null && mytank.shot.isLive) {
            mytank.shot.speed = 5;
            g.draw3DRect(mytank.shot.x, mytank.shot.y, 2,2, false);
        }

//=================================画敌人坦克====================================
        // 画敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank tmp = enemyTanks.get(i);
            if (tmp.isLive) {
                drawTank(tmp.getX(), tmp.getY(), g, tmp.getDirect(), 1);
                // 画出所有子弹
                for (int j = 0; j < tmp.shots.size(); j++) {
                    // 取出子弹
                    Shot shot = tmp.shots.get(j);
                    // 绘制子弹
                    if (shot.isLive) {  // 表示子弹没有越界
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        tmp.shots.remove(shot);
                    }
                }
            }
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
        // 判断坦克类型，设置画笔颜色
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
                x -= 10;
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
                x -= 10;
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


    // 判断子弹是否击中敌人
    public static void hitTank(Shot shot, EnemyTank enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0: // 上
            case 2: // 下
                if (shot.x > enemyTank.getX() && shot.x < enemyTank.getX() + 40 &&
                shot.y > enemyTank.getY() && shot.y < enemyTank.getY() + 60) {
                    shot.isLive = false;
                    enemyTank.isLive = false;
                }
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
        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("用户按下了J");
            mytank.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 判断子弹是否打到敌人
            if (mytank.shot != null && mytank.shot.isLive) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(mytank.shot, enemyTank);
                }
            }

            this.repaint();
        }
    }
}
