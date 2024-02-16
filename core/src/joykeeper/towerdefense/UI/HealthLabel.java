package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import joykeeper.towerdefense.Player;

public class HealthLabel implements DrawableUI{
    Player player;

    BitmapFont font = new BitmapFont();
    public HealthLabel(Player player){
        this.player = player;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        font.setColor(Color.BLACK);
        font.draw(spriteBatch, "Health: " + player.getHealthPoints(), 700, 420);
    }
}
