package joykeeper.towerdefense;

import joykeeper.towerdefense.Scenes.MenuScene;
import joykeeper.towerdefense.Scenes.Scene;

public class SceneManager {
    Scene currentScene;
    public SceneManager(){
        currentScene = new MenuScene();
    }
    public void setScene(Scene scene){
        clearScene();

        this.currentScene = scene;
        this.currentScene.start();
    }
    public Scene getCurrentScene(){
        return this.currentScene;
    }
    private void clearScene(){
        for (int i = 0; i < TowerDefenseGame.instance.updatables.size(); i++) {
            TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(TowerDefenseGame.instance.updatables.get(i));
        }

        for (int i = 0; i < TowerDefenseGame.instance.drawables.size(); i++) {
            TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(TowerDefenseGame.instance.drawables.get(i));
        }

        for (int i = 0; i < TowerDefenseGame.instance.drawableUIs.size(); i++) {
            TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(TowerDefenseGame.instance.drawableUIs.get(i));
        }
    }
}
