package joykeeper.towerdefense.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import joykeeper.towerdefense.*;
import joykeeper.towerdefense.EnemyTypes.*;
import joykeeper.towerdefense.UI.UIController;

import java.util.ArrayList;

public class GameScene extends Scene implements Updateable {
    Field field;
    Player player;

    WaveController waveController;
    PanelHolder panelHolder = new PanelHolder();
    UIController uiController;

    ArrayList<Enemy> enemies = new ArrayList<>();
    int lastEnemyId = 0;
    public GameScene (String map, Wave[] waves, Player player){
        this.field = new Field(map,16, 12, 40, TowerDefenseGame.instance.mousePosition);
        this.waveController = new WaveController(waves);
        this.player = player;
        this.uiController = new UIController(player);
    }

    @Override
    public void update(float deltaTime) {

    }

    public void spawnEnemy(EnemyType enemyType){
        ArrayList<Vector> roadList = field.getRoad();
        Vector[] road = new Vector[roadList.size()];

        for (int i = 0; i < road.length; i++) {
            road[i] = roadList.get(i);
        }

        Enemy enemy;

        switch (enemyType){
            case FAST:
                enemy = new FastEnemy(++lastEnemyId, road);
                break;
            case TANK:
                enemy = new TankEnemy(++lastEnemyId, road);
                break;
            default:
                enemy = new BasicEnemy(++lastEnemyId, road);
        }

        enemies.add(enemy);
        TowerDefenseGame.instance.addUpdatable(enemy);
        TowerDefenseGame.instance.addDrawable(enemy);
    }

}
