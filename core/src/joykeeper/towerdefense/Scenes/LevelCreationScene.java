package joykeeper.towerdefense.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.*;
import joykeeper.towerdefense.Commands.LoadMapCommand;
import joykeeper.towerdefense.Commands.SaveMapCommand;
import joykeeper.towerdefense.TileTypes.Tile;
import joykeeper.towerdefense.UI.Button;
import joykeeper.towerdefense.UI.DrawingTileSelectionSection;
import joykeeper.towerdefense.UI.PlayerStatsSettingSection;
import joykeeper.towerdefense.UI.UIController;

public class LevelCreationScene extends Scene{
    DrawField field;
    Player player;
    Button saveButton;
    Button loadButton;
    PlayerStatsSettingSection playerStatsSettingSection;
    DrawingTileSelectionSection drawingTileSelectionSection;

    public LevelCreationScene(){}

    public void start(){
        this.field = new DrawField(16, 12, 40, TowerDefenseGame.instance.mousePosition);
        this.saveButton = new Button("Save", new Vector(680, 75), new Vector(50, 50), Color.GREEN);
        this.player = new Player(100, 10);
        this.saveButton.setCommand(new SaveMapCommand(this.field, this.player));
        this.loadButton = new Button("Load", new Vector(760, 75), new Vector(50, 50));
        this.drawingTileSelectionSection = new DrawingTileSelectionSection(this.field);
        this.playerStatsSettingSection = new PlayerStatsSettingSection(new Vector(720, 400), player);
        this.loadButton.setCommand(new LoadMapCommand(this.field, this.player, this.playerStatsSettingSection));
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        saveButton.setVisible(field.isMapWorking());
    }
}
