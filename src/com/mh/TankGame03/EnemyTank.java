package com.mh.TankGame03;

import java.util.Vector;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/3/28 - 8:50
 * @ Description: com.mh.TankGame02
 * @ Version: 1.0
 */
public class EnemyTank extends Tank {
    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
