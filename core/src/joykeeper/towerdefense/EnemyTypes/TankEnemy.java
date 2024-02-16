package joykeeper.towerdefense.EnemyTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.Vector;

public class TankEnemy extends Enemy{
    public TankEnemy(int id, Vector[] road) {
        super(id, road, 50, 20, Color.BROWN, 25);
    }
}
