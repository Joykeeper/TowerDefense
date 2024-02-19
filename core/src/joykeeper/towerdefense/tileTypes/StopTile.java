package joykeeper.towerdefense.tileTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.Vector;

public class StopTile extends Tile {
    public StopTile(Vector position){
        super(position);
        this.skin = Color.BLACK;
    }

    public StopTile(Vector position ,Vector size){
        super(position, size);
        this.skin = Color.BLACK;
    }

    @Override
    public void onTileClick() {

    }
}
