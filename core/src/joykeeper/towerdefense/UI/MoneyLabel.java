package joykeeper.towerdefense.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import joykeeper.towerdefense.Player;

public class MoneyLabel implements DrawableUI{
    Player player;

    BitmapFont font = new BitmapFont();
    public MoneyLabel(Player player){
        this.player = player;

    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        font.setColor(Color.BLACK);
        font.draw(spriteBatch, "Money: " + player.getMoney(), 700, 440);
    }
}
