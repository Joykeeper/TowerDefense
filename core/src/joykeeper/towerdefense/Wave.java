package joykeeper.towerdefense;


import joykeeper.towerdefense.EnemyTypes.EnemyType;
import joykeeper.towerdefense.Scenes.GameScene;

public class Wave implements Updateable{
    EnemyType[] enemies;
    int enemyIndToSpawn;
    float ENEMY_SPAWN_RATE;
    float timeToNextSpawn = 0;
    private boolean finished = false;
    public Wave(EnemyType[] enemies, float enemySpawnRate){
        this.enemies = enemies;
        this.enemyIndToSpawn = 0;
        this.ENEMY_SPAWN_RATE = enemySpawnRate;
    }
    public void start(){
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
    }

    @Override
    public void update(float deltaTime) {
        if (enemyIndToSpawn == this.enemies.length) {
            this.finished = true;
            return;
        }

        if (this.timeToNextSpawn <= 0){
            GameScene.instance.enemyController.spawnEnemy(enemies[enemyIndToSpawn++]);
            this.timeToNextSpawn = this.ENEMY_SPAWN_RATE;
        }

        this.timeToNextSpawn -= deltaTime;
    }

    public boolean isFinished() {
        return finished;
    }
}
