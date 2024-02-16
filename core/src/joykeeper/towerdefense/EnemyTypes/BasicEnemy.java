package joykeeper.towerdefense.EnemyTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.Vector;

public class BasicEnemy extends Enemy{
    public BasicEnemy(int id, Vector[] road) {
        super(id, road, 100, 15, Color.VIOLET, 10);
    }
}
