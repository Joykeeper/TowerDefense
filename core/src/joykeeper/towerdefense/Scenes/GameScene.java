package joykeeper.towerdefense.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import joykeeper.towerdefense.*;
import joykeeper.towerdefense.EnemySelectors.ClosestEnemySelector;
import joykeeper.towerdefense.EnemySelectors.FirstEnemySelector;
import joykeeper.towerdefense.EnemyTypes.*;
import joykeeper.towerdefense.TowerTypes.*;
import joykeeper.towerdefense.UI.DrawableUI;
import joykeeper.towerdefense.UI.UIController;

import java.util.ArrayList;

public class GameScene extends Scene {
    Field field;
    private String map;
    Player player;
    Wave[] waves;
    public EnemyController enemyController;
    public PanelHolder panelHolder;
    public UIController uiController;


    public GameScene (String map, Wave[] waves, Player player){
        this.map = map;
        this.waves = waves;
        this.player = player;
    }
    public GameScene (String map, Player player){
        this(map, null, player);
    }
    public GameScene (Player player, Wave[] waves){
        this(null, waves, player);
    }
    public GameScene (Player player){
        this(null, null, player);
    }

    public void start(){
        this.field = new Field(map,16, 12, 40, TowerDefenseGame.instance.mousePosition);
        if(this.waves != null){
            this.enemyController = new EnemyController(this.waves, field.getRoad(), player);
        } else {
            this.enemyController = new EnemyController(field.getRoad(), player);
        }
        this.uiController = new UIController(player, this.enemyController.waveController);
        this.panelHolder = new PanelHolder();

    }

    public Tower spawnTower(int x, int y, TowerType towerType){
        Tower tower;
        switch (towerType){
            case FAST:
                tower = new FastTower(new Vector(x, y), this.enemyController.enemies, new FirstEnemySelector());
                break;
            case SNIPER:
                tower = new SniperTower(new Vector(x, y), this.enemyController.enemies, new FirstEnemySelector());
                break;
            default:
                tower = new BasicTower(new Vector(x, y), this.enemyController.enemies, new ClosestEnemySelector());
        }

        if (player.getMoney() - tower.getCost() < 0){
            return null;
        }

        player.spendMoney(tower.getCost());

        return tower;
    }

}
