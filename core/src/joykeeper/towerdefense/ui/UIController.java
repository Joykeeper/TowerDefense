package joykeeper.towerdefense.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import joykeeper.towerdefense.Player;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.WaveController;

import java.util.ArrayList;

public class UIController implements DrawableUI{
    ArrayList<DrawableUI> uiElements = new ArrayList<>();
    public UIController(Player player, WaveController waveController){
        DrawableUI moneyLabel = new MoneyLabel(player);
        DrawableUI healthLabel = new HealthLabel(player);
        DrawableUI currentWaveLabel = new CurrentWaveLabel(waveController);

        uiElements.add(moneyLabel);
        uiElements.add(healthLabel);
        uiElements.add(currentWaveLabel);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawableUI(this);
    }

    @Override
    public void drawUI(SpriteBatch spriteBatch) {
        for (DrawableUI uiElem :uiElements) {
            uiElem.drawUI(spriteBatch);
        }
    }
}
