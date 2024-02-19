package joykeeper.towerdefense.towerTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.enemySelectors.EnemySelector;
import joykeeper.towerdefense.enemyTypes.Enemy;
import joykeeper.towerdefense.Vector;

import java.util.ArrayList;

public class FastTower extends Tower{
    public static int COST = 25;
    public FastTower(Vector position, ArrayList<Enemy> enemies, EnemySelector enemySelector) {
        super(position, 1, 0.2f, 80, enemies, enemySelector, Color.CYAN, COST);
    }
}
