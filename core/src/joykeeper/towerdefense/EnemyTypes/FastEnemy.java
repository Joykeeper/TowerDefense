package joykeeper.towerdefense.EnemyTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.Vector;

public class FastEnemy extends Enemy{
    public FastEnemy(Vector[] road, int waveNo) {
        super(road, 300, 5, Color.BLUE, 15, waveNo);
    }
    public FastEnemy(int id, Vector[] road) {
        super(road, 300, 5, Color.BLUE, 15, 1);
    }
}
