package joykeeper.towerdefense.TileTypes;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.Vector;

public class RoadTile extends Tile {
    public Vector directsTo;
    public RoadTile(Vector position, Vector directsTo){
        super(position);
        this.skin = Color.GREEN;
        this.directsTo = directsTo;
    }

    @Override
    public void onTileClick() {

    }
}
