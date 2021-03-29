package com.mh.TankGame01;

import javax.swing.*;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 19:03
 * @ Description: com.mh.TankGame
 * @ Version: 1.0
 */
public class TankGame01 extends JFrame {

    MyPanel mp = null;

    public TankGame01() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }
}
