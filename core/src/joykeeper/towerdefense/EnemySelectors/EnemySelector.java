package joykeeper.towerdefense.EnemySelectors;

import joykeeper.towerdefense.EnemyTypes.Enemy;
import joykeeper.towerdefense.TowerTypes.Tower;

import java.util.ArrayList;

public interface EnemySelector {
    Enemy select(Tower self, ArrayList<Enemy> enemies);
}