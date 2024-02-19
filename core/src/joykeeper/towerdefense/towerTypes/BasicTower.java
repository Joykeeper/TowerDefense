package joykeeper.towerdefense.towerTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.enemySelectors.EnemySelector;
import joykeeper.towerdefense.enemyTypes.Enemy;
import joykeeper.towerdefense.Vector;

import java.util.ArrayList;

public class BasicTower extends Tower{
    public BasicTower(Vector position, ArrayList<Enemy> enemies, EnemySelector enemySelector) {
        super(position, 3, 1f, 150,enemies, enemySelector, Color.LIME, 10);
    }
}
