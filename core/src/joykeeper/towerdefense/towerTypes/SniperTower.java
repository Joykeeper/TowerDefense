package joykeeper.towerdefense.towerTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.enemySelectors.EnemySelector;
import joykeeper.towerdefense.enemyTypes.Enemy;
import joykeeper.towerdefense.Vector;

import java.util.ArrayList;

public class SniperTower extends Tower{
    public static int COST = 50;
    public SniperTower(Vector position, ArrayList<Enemy> enemies, EnemySelector enemySelector) {
        super(position, 8,3f, 300, enemies, enemySelector, Color.CORAL, COST);
    }
}
