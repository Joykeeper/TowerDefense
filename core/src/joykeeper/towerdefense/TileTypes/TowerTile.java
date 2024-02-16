package joykeeper.towerdefense.TileTypes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.*;
import joykeeper.towerdefense.AdditionalPanels.TowerSelectionPanel;
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
        TowerDefenseGame.instance.panelHolder.setPanel(new TowerSelectionPanel(this));

        /*if(this.tower == null) {
            if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
                this.tower = TowerDefenseGame.instance.spawnTower((int) this.position.x,(int) this.position.y, TowerType.SNIPER);
            } else if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)) {
                this.tower = TowerDefenseGame.instance.spawnTower((int) this.position.x,(int) this.position.y, TowerType.FAST);
            }
        }*/
    }
    public void spawnTower(TowerType tt){
        if(this.tower == null) {
            this.tower = TowerDefenseGame.instance.spawnTower((int) this.position.x,(int) this.position.y, tt);
        }
    }

}
