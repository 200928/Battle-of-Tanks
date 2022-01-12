package com.mh.TankGame_0_1;

import com.mh.TankGame03.MyTank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/29 - 21:00
 * @ Description: com.mh.TankGame_0_1
 * @ Version: 1.0
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    int x = 1000;
    int y = 750;
    private OurTank ourTank = null;   // 定义自己的坦克
    private Vector<EnemyTank> enemyTanks = new Vector<>();  // 定义敌方坦克

    // 构造器用来实例化坦克
    public MyPanel() {
        // 实例我的坦克
        ourTank = new OurTank(480, 690); // 我的坦克布置在面板的最下中间位置
        ourTank.setType(0);
        ourTank.setSpeed(10);

        // 实例敌方坦克 enemyTankSize 个
        // 敌人坦克数量
        int enemyTankSize = new Random().nextInt(2) + 5;
        for (int i = 0; i < enemyTankSize; i++) {
            int x = new Random().nextInt(800) + 50; // 随机横坐标
            int y = new Random().nextInt(500) + 50; // 随机纵坐标
            EnemyTank enemyTank = new EnemyTank(x, y);
            enemyTank.setDirect((int) (Math.random() * 4)); // 方向随机 0,1,2,3
            enemyTank.setSpeed(5);
            enemyTank.setType(1);   // 设置类型，其实不用设置，默认为1
            new Thread(enemyTank).start();
            enemyTanks.add(enemyTank);
            // 实例化子弹，根据坦克方向
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            new Thread(shot).start();
            enemyTank.shots.add(shot);
        }
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        // 面板填充颜色，默认灰色
        g.fillRect(0, 0, x, y);

        // 绘制我方坦克和子弹
        drawMyTank(g);

        // 绘制敌方坦克和子弹
        drawEnemyTank(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            ourTank.setDirect(0);
            if (ourTank.getY() > 0) {
                ourTank.moveUP();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            ourTank.setDirect(1);
            if (ourTank.getX() + 60 < 1000) {
                ourTank.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            ourTank.setDirect(2);
            if (ourTank.getY() + 60 < 750) {
                ourTank.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            ourTank.setDirect(3);
            if (ourTank.getX() > 0) {
                ourTank.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            // 按下 J 键就创建子弹，会进入shotEnemyTank进入判断是否要创建
            ourTank.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * 1. 判断是否击中敌人
     */
    @Override
    public void run() {
        while (true) {
            if (enemyTanks.size() < 5) {
                int x = new Random().nextInt(800) + 50; // 随机横坐标
                int y = new Random().nextInt(500) + 50; // 随机纵坐标
                EnemyTank enemyTank = new EnemyTank(x, y);
                enemyTank.setDirect((int) (Math.random() * 4)); // 方向随机 0,1,2,3
                enemyTank.setSpeed(5);
                enemyTank.setType(1);   // 设置类型，其实不用设置，默认为1
                new Thread(enemyTank).start();
                enemyTanks.add(enemyTank);
                // 实例化子弹，根据坦克方向
                Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                new Thread(shot).start();
                enemyTank.shots.add(shot);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 判断是否击中了敌人坦克
            hitEnemyTank(ourTank.shots, enemyTanks);
            repaint();
        }
    }

    // 判断我方的子弹是否击中敌人的坦克
    private void hitEnemyTank(Vector<Shot> vector, Vector<EnemyTank> enemyTanks) {
        for (Shot shot : vector) {
            // 这里的 enemyTank 代表一个敌方坦克，然后再调用 hitTank 判断该子弹是否击中该坦克
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                hitTank(shot, enemyTank);
            }
        }
    }

    // 用自己的一个子弹去判断是否打中敌方一辆坦克
    private void hitTank(Shot shot, EnemyTank enemyTank) {
        // 根据方向判断是否打中
        switch (enemyTank.getDirect()) {
            // 上下方向
            case 0:
            case 2:
                if (shot.getX() > enemyTank.getX() && shot.getX() < enemyTank.getX() + 40 &&
                shot.getY() > enemyTank.getY() && shot.getY() < enemyTank.getY() + 60) {
                    shot.setLive(false);
                    enemyTank.setLive(false);
                    enemyTanks.remove(enemyTank);
                }
                break;
            // 左右方向
            case 1:
            case 3:
                if (shot.getX() > enemyTank.getX() && shot.getX() < enemyTank.getX() + 60 &&
                shot.getY() > enemyTank.getY() && shot.getY() < enemyTank.getY() + 40) {
                    shot.setLive(false);
                    enemyTank.setLive(false);
                    enemyTanks.remove(enemyTank);
                }
        }
    }

    // 绘制我方坦克和子弹
    private void drawMyTank(Graphics g) {
        // 绘制自己的坦克
        drawTank(ourTank.getX(), ourTank.getY(), ourTank.getDirect(), ourTank.getType(), g);
        // 自己子弹射击
        for (int i = 0; i < ourTank.shots.size(); i++) {
            Shot shot = ourTank.shots.get(i);
            if (shot != null && shot.getLive()) {
                shot.setSpeed(5);
                g.draw3DRect(shot.getX(), shot.getY(), 2,2, false);
            } else {    // 若生命已经结束则从集合中移除
                ourTank.shots.remove(shot);
            }
        }
    }

    // 绘制敌方坦克和子弹
    private void drawEnemyTank(Graphics g) {
        // 绘制敌方坦克
        for (EnemyTank enemyTank : enemyTanks) {
            if (enemyTank.isLive()) {   // 不为空即绘制
                drawTank(enemyTank.getX(), enemyTank.getY(), enemyTank.getDirect(), enemyTank.getType(), g);
                // 绘制敌方子弹
                for (int i = 0; i < enemyTank.shots.size(); i++) {
                    Shot shot = enemyTank.shots.get(i);
                    if (shot.isLive()) {
                        g.draw3DRect(shot.getX(), shot.getY(), 2, 2, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }


    /**
     * @param x 需要绘制坦克的横坐标
     * @param y 需要绘制坦克的纵坐标
     * @param direct 坦克的方向
     * @param type 坦克的类型(我方还是敌方)
     */
    private void drawTank(int x, int y, int direct, int type, Graphics graphics) {
        // 首先判断坦克是我方还是敌方，设置画笔颜色
        if (type == 0) {
            graphics.setColor(Color.yellow);
        } else {
            graphics.setColor(Color.cyan);
        }

        // 然后绘制坦克的形状
        switch (direct) {
            case 0: // 向上
                graphics.fill3DRect(x, y, 10, 60, false);  // 左边轮子
                graphics.fill3DRect(x + 10, y + 10, 20, 40, false);    // 身体
                graphics.fill3DRect(x + 30, y, 10, 60, false); // 右轮子
                graphics.drawOval(x + 10, y + 20, 18, 18); // 炮台
                graphics.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: // 向右
                graphics.fill3DRect(x, y, 60, 10, false);  // 上边轮子
                graphics.fill3DRect(x + 10, y + 10, 40, 20, false);    // 身体
                graphics.fill3DRect(x, y + 30, 60, 10, false); // 下边轮子
                graphics.drawOval(x + 20, y + 10, 18, 18);
                graphics.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: // 向下
                graphics.fill3DRect(x, y, 10, 60, false);  // 左边轮子
                graphics.fill3DRect(x + 10, y + 10, 20, 40, false);    // 身体
                graphics.fill3DRect(x + 30, y, 10, 60, false); // 右轮子
                graphics.drawOval(x + 10, y + 20, 18, 18); // 炮台
                graphics.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: // 向左
                graphics.fill3DRect(x, y, 60, 10, false);  // 上边轮子
                graphics.fill3DRect(x + 10, y + 10, 40, 20, false);    // 身体
                graphics.fill3DRect(x, y + 30, 60, 10, false); // 下边轮子
                graphics.drawOval(x + 20, y + 10, 18, 18);
                graphics.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

}
