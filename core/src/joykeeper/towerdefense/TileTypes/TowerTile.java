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

    @Override
    public void onTileClick() {
        GameScene.instance.panelHolder.setPanel(new TowerSelectionPanel(this));
    }
    public void spawnTower(TowerType tt){
        if(this.tower == null) {
            this.tower = GameScene.instance.spawnTower((int) this.position.x,(int) this.position.y, tt);
        }
    }

}
