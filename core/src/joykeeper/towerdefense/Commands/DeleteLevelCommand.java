package joykeeper.towerdefense.Commands;

import joykeeper.towerdefense.Scenes.LevelSelectionScene;
import joykeeper.towerdefense.TowerDefenseGame;

import java.io.File;
import java.io.IOException;

public class DeleteLevelCommand implements Command{
    String levelName;
    public DeleteLevelCommand(String levelName){
        this.levelName = levelName;
    }
    @Override
    public void execute() {
        File myObj = new File("levels/" + this.levelName);
        myObj.delete();
        TowerDefenseGame.instance.sceneManager.setScene(new LevelSelectionScene());
    }
}
