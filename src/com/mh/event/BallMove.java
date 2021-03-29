package com.mh.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 20:05
 * @ Description: com.mh.event
 * @ Version: 1.0
 * 演示小球通过键盘移动
 */
public class BallMove extends JFrame {

    MyPanel mp = null;

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BallMove();
    }
}

/**
 * KeyListener 是一个监听键盘事件
 */
class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(x, y, 20, 20);
    }

    // 有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 当某个键按下触发
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((char)e.getKeyCode() + "被按下..");
        // 根据按下不同的键处理小球的移动
        if (e.getKeyCode() == KeyEvent.VK_W) {
            y -= 2;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            y += 2;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            x -= 2;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            x += 2;
        }
        this.repaint(); // 重绘
    }

    // 当某个键释放会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
