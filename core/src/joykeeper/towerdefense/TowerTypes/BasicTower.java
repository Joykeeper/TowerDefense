package joykeeper.towerdefense.TowerTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.EnemySelectors.EnemySelector;
import joykeeper.towerdefense.EnemyTypes.Enemy;
import joykeeper.towerdefense.Vector;

import java.util.ArrayList;

public class BasicTower extends Tower{
    public BasicTower(Vector position, ArrayList<Enemy> enemies, EnemySelector enemySelector) {
        super(position, 3, 1f, 150,enemies, enemySelector, Color.LIME, 10);
    }
}
