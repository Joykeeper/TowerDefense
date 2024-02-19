package joykeeper.towerdefense.ui;

import com.badlogic.gdx.graphics.Color;

import joykeeper.towerdefense.commands.ChooseDrawingTileCommand;
import joykeeper.towerdefense.DrawField;
import joykeeper.towerdefense.tileTypes.TileType;
import joykeeper.towerdefense.Vector;

public class DrawingTileSelectionSection {
    MyLabel sectionName;
    Button towerTileButton;
    Button roadTileUButton;
    Button roadTileDButton;
    Button roadTileRButton;
    Button roadTileLButton;
    Button startTileRButton;
    Button startTileLButton;
    Button startTileUButton;
    Button startTileDButton;
    Button voidTileButton;
    Button stopTileButton;
    DrawField drawField;

    public DrawingTileSelectionSection(DrawField drawField){
        sectionName = new MyLabel("Select tile", new Vector(720, 300));

        this.voidTileButton = new Button("Void", new Vector(680, 170), new Vector(40, 40), Color.GRAY);
        this.towerTileButton = new Button("Tower", new Vector(720, 170), new Vector(40, 40), Color.YELLOW);

        this.roadTileRButton = new Button("Right", new Vector(660, 210), new Vector(40, 40), Color.GREEN);
        this.roadTileLButton = new Button("Left", new Vector(700, 210), new Vector(40, 40), Color.GREEN);
        this.roadTileUButton = new Button("Up", new Vector(740, 210), new Vector(40, 40), Color.GREEN);
        this.roadTileDButton = new Button("Down", new Vector(780, 210), new Vector(40, 40), Color.GREEN);


        this.startTileRButton = new Button("Right", new Vector(660, 250), new Vector(40, 40), Color.BLUE);
        this.startTileLButton = new Button("Left", new Vector(700, 250), new Vector(40, 40), Color.BLUE);
        this.startTileUButton = new Button("Up", new Vector(740, 250), new Vector(40, 40), Color.BLUE);
        this.startTileDButton = new Button("Down", new Vector(780, 250), new Vector(40, 40), Color.BLUE);

        this.stopTileButton = new Button("Stop", new Vector(760, 170), new Vector(40, 40), Color.BLACK, Color.WHITE);
        this.drawField = drawField;

        this.towerTileButton.setCommand(new ChooseDrawingTileCommand(TileType.TOWER, drawField));
        this.voidTileButton.setCommand(new ChooseDrawingTileCommand(TileType.VOID, drawField));
        this.startTileRButton.setCommand(new ChooseDrawingTileCommand(TileType.START_R, drawField));
        this.startTileLButton.setCommand(new ChooseDrawingTileCommand(TileType.START_L, drawField));
        this.startTileUButton.setCommand(new ChooseDrawingTileCommand(TileType.START_U, drawField));
        this.startTileDButton.setCommand(new ChooseDrawingTileCommand(TileType.START_D, drawField));
        this.roadTileUButton.setCommand(new ChooseDrawingTileCommand(TileType.ROAD_U, drawField));
        this.roadTileDButton.setCommand(new ChooseDrawingTileCommand(TileType.ROAD_D, drawField));
        this.roadTileRButton.setCommand(new ChooseDrawingTileCommand(TileType.ROAD_R, drawField));
        this.roadTileLButton.setCommand(new ChooseDrawingTileCommand(TileType.ROAD_L, drawField));
        this.stopTileButton.setCommand(new ChooseDrawingTileCommand(TileType.STOP, drawField));
    }
}
