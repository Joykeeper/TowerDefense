package joykeeper.towerdefense.Commands;

import joykeeper.towerdefense.DrawField;
import joykeeper.towerdefense.TileTypes.TileType;

public class ChooseDrawingTileCommand implements Command{
    TileType tileType;
    DrawField drawField;
    public ChooseDrawingTileCommand(TileType tileType, DrawField drawingField){
        this.tileType = tileType;
        this.drawField = drawingField;
    }
    @Override
    public void execute() {
        this.drawField.setDrawingTile(tileType);
    }
}
