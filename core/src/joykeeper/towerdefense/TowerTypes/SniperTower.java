package joykeeper.towerdefense.TowerTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.EnemySelectors.EnemySelector;
import joykeeper.towerdefense.EnemyTypes.Enemy;
import joykeeper.towerdefense.Vector;

import java.util.ArrayList;

public class SniperTower extends Tower{
    public SniperTower(Vector position, ArrayList<Enemy> enemies, EnemySelector enemySelector) {
        super(position, 8,3f, 300, enemies, enemySelector, Color.CORAL, 50);
    }
}
