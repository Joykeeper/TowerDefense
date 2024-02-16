package joykeeper.towerdefense.TowerTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.EnemySelectors.EnemySelector;
import joykeeper.towerdefense.EnemyTypes.Enemy;
import joykeeper.towerdefense.Vector;

import java.util.ArrayList;

public class FastTower extends Tower{
    public FastTower(Vector position, ArrayList<Enemy> enemies, EnemySelector enemySelector) {
        super(position, 1, 0.2f, 80, enemies, enemySelector, Color.CYAN, 25);
    }
}
