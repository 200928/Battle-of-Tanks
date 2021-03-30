package com.mh.TankGame_0_1;

import javax.swing.*;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/29 - 22:06
 * @ Description: com.mh.TankGame_0_1
 * @ Version: 1.0
 */
public class game extends JFrame {

    private game() {
        MyPanel mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1016, 789);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        game game = new game();
    }
}
