package joykeeper.towerdefense.TileTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.EnemyTypes.EnemyType;
import joykeeper.towerdefense.Scenes.GameScene;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Vector;

public class StartTile extends Tile {
    public Vector directsTo;
    public StartTile(Vector position, Vector directsTo){
        super(position);
        this.skin = Color.BLUE;
        this.directsTo = directsTo;
    }

    @Override
    public void onTileClick() {
        GameScene.instance.enemyController.spawnEnemy(EnemyType.BASIC);
    }
}
