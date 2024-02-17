package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import joykeeper.towerdefense.Player;
import joykeeper.towerdefense.TowerDefenseGame;

import java.util.ArrayList;

public class UIController implements DrawableUI{
    ArrayList<DrawableUI> uiElements = new ArrayList<>();
    public UIController(Player player){
        DrawableUI moneyLabel = new MoneyLabel(player);
        DrawableUI healthLabel = new HealthLabel(player);

        uiElements.add(moneyLabel);
        uiElements.add(healthLabel);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawableUI(this);
    }

    @Override
    public void drawUI(SpriteBatch spriteBatch) {
        for (DrawableUI uiElem :uiElements) {
            uiElem.drawUI(spriteBatch);
        }
    }
}
