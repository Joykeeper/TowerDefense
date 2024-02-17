package joykeeper.towerdefense.Scenes;

import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.UI.MenuUIController;
import joykeeper.towerdefense.UI.UIController;

public class MenuScene extends Scene{
    MenuUIController uiController;
    public MenuScene(){}

    @Override
    public void start() {
        this.uiController = new MenuUIController();
        this.addDrawable(uiController);
    }
}
