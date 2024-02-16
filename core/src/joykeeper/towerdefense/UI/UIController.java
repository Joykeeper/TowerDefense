package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import joykeeper.towerdefense.Player;

import java.util.ArrayList;

public class UIController implements DrawableUI{
    ArrayList<DrawableUI> uiElements = new ArrayList<>();
    public UIController(Player player){
        uiElements.add(new MoneyLabel(player));
        uiElements.add(new HealthLabel(player));
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        for (DrawableUI uiElem :uiElements) {
            uiElem.draw(spriteBatch);
        }
    }
}
