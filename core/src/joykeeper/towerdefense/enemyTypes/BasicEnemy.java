package joykeeper.towerdefense.enemyTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.Vector;

public class BasicEnemy extends Enemy{
    public BasicEnemy(Vector[] road, int waveNo) {
        super(road, 100, 15, Color.VIOLET, 10, waveNo);
    }
    public BasicEnemy(Vector[] road) {
        super(road, 100, 15, Color.VIOLET, 10, 1);
    }
}
