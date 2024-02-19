package joykeeper.towerdefense.tileTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.*;
import joykeeper.towerdefense.additionalPanels.TowerSelectionPanel;
import joykeeper.towerdefense.scenes.GameScene;
import joykeeper.towerdefense.towerTypes.Tower;
import joykeeper.towerdefense.towerTypes.TowerType;


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
        if (this.tower != null){
            return;
        }
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
