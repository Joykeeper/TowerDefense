package joykeeper.towerdefense.TileTypes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.*;
import joykeeper.towerdefense.AdditionalPanels.TowerSelectionPanel;
import joykeeper.towerdefense.Scenes.GameScene;
import joykeeper.towerdefense.TowerTypes.Tower;
import joykeeper.towerdefense.TowerTypes.TowerType;


public class TowerTile extends Tile implements Drawable {
    private Tower tower;
    public TowerTile(Vector position){
        super(position);
        this.skin = Color.YELLOW;
    }
    public TowerTile(Vector position, Vector size){
        super(position, size);
        this.skin = Color.YELLOW;
    }

    @Override
    public void onTileClick() {
        GameScene gs = (GameScene) (TowerDefenseGame.instance.sceneManager.getCurrentScene());
        gs.panelHolder.setPanel(new TowerSelectionPanel(this));
    }
    public void spawnTower(TowerType tt){
        if(this.tower == null) {
            GameScene gs = (GameScene) (TowerDefenseGame.instance.sceneManager.getCurrentScene());

            this.tower = gs.spawnTower((int) this.position.x,(int) this.position.y, tt);
        }
    }

}
