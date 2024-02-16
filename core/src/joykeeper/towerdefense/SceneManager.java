package joykeeper.towerdefense;

import joykeeper.towerdefense.Scenes.MenuScene;
import joykeeper.towerdefense.Scenes.Scene;

public class SceneManager {
    Scene currentScene;
    public SceneManager(){
        currentScene = new MenuScene();

        TowerDefenseGame.instance.addUpdatable(currentScene);
    }
    public void setScene(Scene scene){
        TowerDefenseGame.instance.addObjectToRemove(currentScene);

        this.currentScene = scene;
    }
}
