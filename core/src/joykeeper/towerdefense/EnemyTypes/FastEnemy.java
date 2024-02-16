package joykeeper.towerdefense.EnemyTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.Vector;

public class FastEnemy extends Enemy{
    public FastEnemy(int id, Vector[] road) {
        super(id, road, 300, 5, Color.BLUE, 15);
    }
}
