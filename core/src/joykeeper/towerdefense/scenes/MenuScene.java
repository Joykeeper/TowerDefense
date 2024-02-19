package joykeeper.towerdefense.scenes;

import joykeeper.towerdefense.ui.MenuUIController;

public class MenuScene extends Scene{
    MenuUIController uiController;
    public MenuScene(){}

    @Override
    public void start() {
        this.uiController = new MenuUIController();
        this.addDrawable(uiController);
    }
}
