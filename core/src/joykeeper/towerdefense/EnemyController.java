package joykeeper.towerdefense;

import joykeeper.towerdefense.EnemyTypes.*;

import java.util.ArrayList;

public class EnemyController implements Updateable{
    public ArrayList<Enemy> enemies;
    WaveController waveController;
    int lastEnemyId = 0;
    ArrayList<Vector> road;
    public EnemyController(Wave[] waves, ArrayList<Vector> road){
        this.enemies = new ArrayList<>();
        this.road = road;
        if (waves == null){
            this.waveController = new WaveController();
        } else {
            this.waveController = new WaveController(waves);
        }

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);

    }
    public EnemyController(ArrayList<Vector> road){
        this(null, road);
    }

    @Override
    public void update(float deltaTime) {
        int removedEnemies = 0;
        for (int i = 0; i < this.enemies.size() - removedEnemies; i++) {
            if(this.enemies.get(i).isDead()){
                TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(this.enemies.get(i));
                this.enemies.remove(this.enemies.get(i));
                removedEnemies++;
            } else if(enemies.get(i).hasReachedEnd()){
                TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(this.enemies.get(i));
                this.enemies.remove(this.enemies.get(i));
                removedEnemies++;
            }
        }

        for (int i = 0; i < this.waveController.waves.length; i++) {
            if(this.waveController.waves[i].isFinished()){
                TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(this.waveController.waves[i]);
            }
        }
    }

    public void spawnEnemy(EnemyType enemyType){
        Vector[] roadArr = new Vector[road.size()];

        for (int i = 0; i < roadArr.length; i++) {
            roadArr[i] = road.get(i);
        }

        Enemy enemy;

        switch (enemyType){
            case FAST:
                enemy = new FastEnemy(++lastEnemyId, roadArr);
                break;
            case TANK:
                enemy = new TankEnemy(++lastEnemyId, roadArr);
                break;
            default:
                enemy = new BasicEnemy(++lastEnemyId, roadArr);
        }

        this.enemies.add(enemy);
    }

}
