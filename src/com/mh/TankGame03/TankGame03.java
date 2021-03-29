package com.mh.TankGame03;

import javax.swing.*;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 19:03
 * @ Description: com.mh.TankGame
 * @ Version: 1.0
 */
public class TankGame03 extends JFrame {

    MyPanel mp = null;

    public TankGame03() {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankGame03 tankGame03 = new TankGame03();
    }
}
