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
    public static GameScene instance;
    Field field;
    private String map;
    Player player;
    Wave[] waves;
    public EnemyController enemyController;
    public PanelHolder panelHolder = new PanelHolder();
    public UIController uiController;

    public ArrayList<Bullet> bullets = new ArrayList<>();


    public GameScene (String map, Wave[] waves, Player player){
        instance = this;

        this.map = map;
        this.waves = waves;
        this.player = player;
    }
    public GameScene (String map, Player player){
        this(map, null, player);
    }
    public GameScene (Player player){
        this(null, null, player);
    }
    public void start(){
        this.field = new Field(map,16, 12, 40, TowerDefenseGame.instance.mousePosition);
        if(waves != null){
            this.enemyController = new EnemyController(this.waves, field.getRoad());
        } else {
            this.enemyController = new EnemyController(field.getRoad());
        }
        this.uiController = new UIController(player);
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
