package joykeeper.towerdefense.EnemyTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.Vector;

public class TankEnemy extends Enemy{
    public TankEnemy(Vector[] road, int waveNo) {
        super(road, 50, 20, Color.BROWN, 25, waveNo);
    }
    public TankEnemy(int id, Vector[] road) {
        super(road, 50, 20, Color.BROWN, 25, 1);
    }
}
