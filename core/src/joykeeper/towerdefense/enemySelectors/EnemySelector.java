package joykeeper.towerdefense.enemySelectors;

import joykeeper.towerdefense.enemyTypes.Enemy;
import joykeeper.towerdefense.towerTypes.Tower;

import java.util.ArrayList;

public interface EnemySelector {
    Enemy select(Tower self, ArrayList<Enemy> enemies);
}