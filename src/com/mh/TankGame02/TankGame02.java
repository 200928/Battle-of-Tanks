package com.mh.TankGame02;

import javax.swing.*;
import java.awt.event.KeyListener;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/27 - 19:03
 * @ Description: com.mh.TankGame
 * @ Version: 1.0
 */
public class TankGame02 extends JFrame {

    MyPanel mp = null;

    public TankGame02() {
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankGame02 tankGame02 = new TankGame02();
    }
}
