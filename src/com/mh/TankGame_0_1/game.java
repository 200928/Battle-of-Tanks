package com.mh.TankGame_0_1;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;

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
        HashMap<String, Integer> map = new HashMap<>();
        map.put("h", 34);
        map.put("k", -34);
        System.out.println(map.get("k"));
        System.out.println(map.get("h"));
        game game = new game();
//        HashSet<Integer> hashSet = new HashSet<>();
//        hashSet.add(1);
//        hashSet.add(2);
//        hashSet.add(3);
//        Integer[] a = new Integer[5];
//        hashSet.toArray(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
    }
}
