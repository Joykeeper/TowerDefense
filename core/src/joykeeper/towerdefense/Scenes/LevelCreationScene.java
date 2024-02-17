package joykeeper.towerdefense.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import joykeeper.towerdefense.*;
import joykeeper.towerdefense.Commands.LoadMapCommand;
import joykeeper.towerdefense.Commands.SaveMapCommand;
import joykeeper.towerdefense.TileTypes.Tile;
import joykeeper.towerdefense.UI.Button;
import joykeeper.towerdefense.UI.DrawingTileSelectionSection;
import joykeeper.towerdefense.UI.UIController;

public class LevelCreationScene extends Scene{
    DrawField field;
    Button saveButton;
    Button loadButton;
    DrawingTileSelectionSection drawingTileSelectionSection;

    public LevelCreationScene(){}

    public void start(){
        this.field = new DrawField(16, 12, 40, TowerDefenseGame.instance.mousePosition);
        this.saveButton = new Button("Save", new Vector(720, 150), new Vector(100, 50));
        this.saveButton.setCommand(new SaveMapCommand(this.field));
        this.loadButton = new Button("Load", new Vector(720, 75), new Vector(100, 50));
        this.loadButton.setCommand(new LoadMapCommand(this.field));
        this.drawingTileSelectionSection = new DrawingTileSelectionSection(this.field);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        saveButton.setVisible(field.isMapWorking());
    }
}
