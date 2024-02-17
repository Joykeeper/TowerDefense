package joykeeper.towerdefense.Commands;

import joykeeper.towerdefense.SceneManager;
import joykeeper.towerdefense.Scenes.Scene;
import joykeeper.towerdefense.TowerDefenseGame;

public class ChangeSceneCommand implements Command{
    Scene sceneToSet;
    public ChangeSceneCommand(Scene sceneToSet){
        this.sceneToSet = sceneToSet;
    }
    @Override
    public void execute() {
        TowerDefenseGame.instance.sceneManager.setScene(this.sceneToSet);
    }
}
