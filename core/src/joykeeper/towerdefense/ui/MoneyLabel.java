package joykeeper.towerdefense.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import joykeeper.towerdefense.Player;

public class MoneyLabel implements DrawableUI{
    Player player;

    BitmapFont font = new BitmapFont();
    public MoneyLabel(Player player){
        this.player = player;

    }

    @Override
    public void drawUI(SpriteBatch spriteBatch) {
        font.setColor(Color.BLACK);
        font.draw(spriteBatch, "Money: " + player.getMoney(), 700, 440);
    }
}
