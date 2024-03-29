package joykeeper.towerdefense.enemySelectors;

import joykeeper.towerdefense.enemyTypes.Enemy;
import joykeeper.towerdefense.towerTypes.Tower;

import java.util.ArrayList;

public class FirstEnemySelector implements EnemySelector {
    public Enemy select(Tower self, ArrayList<Enemy> enemies) {
        if(enemies.isEmpty()) return null;
        Enemy firstEnemy = enemies.get(0);
        for (Enemy e:enemies) {
            if(firstEnemy.getCurrentRoadPercentage() < e.getCurrentRoadPercentage()){
                firstEnemy = e;
            }
        }
        return firstEnemy;
    }
}
