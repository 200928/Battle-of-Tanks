package com.mh.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 16:46
 * @ Description: com.mh.draw
 * @ Version: 1.0
 */
public class DrawCircle extends JFrame {
    MyPanel mp = null;

    public DrawCircle() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DrawCircle();
    }
}

// 定义一个画板类，继承 JPanel
class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("调用");
        // 画一个圆
        g.drawOval(10, 10, 100, 100);
        g.clearRect(10, 10, 40, 50);
    }
}