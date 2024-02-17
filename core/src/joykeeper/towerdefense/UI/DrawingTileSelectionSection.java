package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Commands.ChooseDrawingTileCommand;
import joykeeper.towerdefense.DrawField;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TileTypes.TileType;
import joykeeper.towerdefense.Vector;

public class DrawingTileSelectionSection {
    MyLabel sectionName;
    Button towerTileButton;
    Button roadTileButton;
    Button startTileButton;
    Button voidTileButton;
    Button stopTileButton;
    DrawField drawField;

    public DrawingTileSelectionSection(DrawField drawField){
        sectionName = new MyLabel("Select tile", new Vector(720, 300));

        this.voidTileButton = new Button("Void", new Vector(680, 250), new Vector(40, 40), Color.GRAY);
        this.towerTileButton = new Button("Tower", new Vector(720, 250), new Vector(40, 40), Color.YELLOW);
        this.roadTileButton = new Button("Road", new Vector(760, 250), new Vector(40, 40), Color.GREEN);


        this.startTileButton = new Button("Start", new Vector(680, 210), new Vector(40, 40), Color.BLUE);
        this.stopTileButton = new Button("Stop", new Vector(720, 210), new Vector(40, 40), Color.BLACK, Color.WHITE);
        this.drawField = drawField;

        this.towerTileButton.setCommand(new ChooseDrawingTileCommand(TileType.TOWER, drawField));
        this.voidTileButton.setCommand(new ChooseDrawingTileCommand(TileType.VOID, drawField));
        this.startTileButton.setCommand(new ChooseDrawingTileCommand(TileType.START, drawField));
        this.roadTileButton.setCommand(new ChooseDrawingTileCommand(TileType.ROAD, drawField));
        this.stopTileButton.setCommand(new ChooseDrawingTileCommand(TileType.STOP, drawField));
    }
}
