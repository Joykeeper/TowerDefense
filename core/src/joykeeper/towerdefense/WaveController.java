package joykeeper.towerdefense;

import joykeeper.towerdefense.EnemyTypes.Enemy;
import joykeeper.towerdefense.EnemyTypes.EnemyType;

import java.util.ArrayList;

public class WaveController implements Updateable{
    int currentWave;
    int waveCounter = 0;
    public Wave[] waves;
    float ENEMY_SPAWN_RATE = 1f;
    float TIME_BETWEEN_WAVES = 6f;
    float timeToNextWave = 3f;
    public int amountOfWaves;
    boolean infiniteWaves = false;
    public WaveController(){
        this.currentWave = 0;
        this.infiniteWaves = true;
        this.amountOfWaves = -1;
        this.waves = new Wave[0];
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
    }

    public WaveController(Wave[] waves){
        this.currentWave = 0;
        this.waves = waves;
        this.amountOfWaves = waves.length;
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
    }

    @Override
    public void update(float deltaTime) {
        if (currentWave == waves.length){
            if (infiniteWaves){
                this.waves = new Wave[1];
                for (int i = 0; i < this.waves.length; i++) {
                    this.waves[i] = new Wave(new EnemyType[]{EnemyType.BASIC, EnemyType.FAST, EnemyType.TANK}, this.ENEMY_SPAWN_RATE);
                }
                currentWave = 0;
            }else {
                return;
            }
        }

        if (this.timeToNextWave <= 0){
            waves[currentWave++].start();
            this.waveCounter++;
            this.timeToNextWave = this.TIME_BETWEEN_WAVES;
        }



        timeToNextWave -= deltaTime;
    }

    public int getWaveCounter(){
        return this.waveCounter;
    }
}
