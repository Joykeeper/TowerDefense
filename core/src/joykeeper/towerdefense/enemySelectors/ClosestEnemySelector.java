package joykeeper.towerdefense.enemySelectors;

import joykeeper.towerdefense.enemyTypes.Enemy;
import joykeeper.towerdefense.towerTypes.Tower;

import java.util.ArrayList;

public class ClosestEnemySelector implements EnemySelector {
    public Enemy select(Tower self, ArrayList<Enemy> enemies) {
        if(enemies.isEmpty()) return null;
        Enemy closestEnemy = enemies.get(0);
        for (Enemy e:enemies) {
            if((closestEnemy.getPosition().x - self.getPixelPos().x)* (closestEnemy.getPosition().x - self.getPixelPos().x)
                    + (closestEnemy.getPosition().y - self.getPixelPos().y)*(closestEnemy.getPosition().y - self.getPixelPos().y) >
                    (e.getPosition().x - self.getPixelPos().x)*(e.getPosition().x - self.getPixelPos().x)
                            + (e.getPosition().y - self.getPixelPos().y)*(e.getPosition().y - self.getPixelPos().y)){
                closestEnemy = e;
            }
        }
        return closestEnemy;
    }
}