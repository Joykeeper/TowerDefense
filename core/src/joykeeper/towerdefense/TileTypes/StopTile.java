package joykeeper.towerdefense.TileTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.Vector;

public class StopTile extends Tile {
    public StopTile(Vector position){
        super(position);
        this.skin = Color.BLACK;
    }

    @Override
    public void onTileClick() {

    }
}
