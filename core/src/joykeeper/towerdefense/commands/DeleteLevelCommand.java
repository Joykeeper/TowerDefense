package joykeeper.towerdefense.commands;

import joykeeper.towerdefense.scenes.LevelSelectionScene;
import joykeeper.towerdefense.TowerDefenseGame;

import java.io.File;

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
