package joykeeper.towerdefense;

import joykeeper.towerdefense.EnemyTypes.Enemy;
import joykeeper.towerdefense.EnemyTypes.EnemyType;

import java.util.ArrayList;

public class WaveController implements Updateable{
    int currentWave;
    Wave[] waves;
    float ENEMY_SPAWN_RATE = 1f;
    float TIME_BETWEEN_WAVES = 6f;
    float timeToNextWave = 0;
    public WaveController(){
        this.currentWave = 0;
        this.waves = new Wave[5];
        for (int i = 0; i < this.waves.length; i++) {
            this.waves[i] = new Wave(new EnemyType[]{EnemyType.BASIC, EnemyType.FAST, EnemyType.TANK}, this.ENEMY_SPAWN_RATE);
        }
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
    }

    public WaveController(Wave[] waves){
        this.currentWave = 0;
        this.waves = waves;
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
    }

    @Override
    public void update(float deltaTime) {
        if (currentWave == waves.length){
            return;
        }

        if (this.timeToNextWave <= 0){
            waves[currentWave++].start();
            this.timeToNextWave = this.TIME_BETWEEN_WAVES;
        }

        timeToNextWave -= deltaTime;
    }
}
