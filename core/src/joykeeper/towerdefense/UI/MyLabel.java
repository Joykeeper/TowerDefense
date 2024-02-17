package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import joykeeper.towerdefense.Scenes.GameScene;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Vector;

public class MyLabel implements DrawableUI{
    Vector position;
    String text;
    BitmapFont font = new BitmapFont();
    public MyLabel(String text, Vector position){
        this.text = text;
        this.position = new Vector(position.x-text.length()*3.6f, position.y);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawableUI(this);
    }
    @Override
    public void drawUI(SpriteBatch spriteBatch) {
        font.setColor(Color.BLACK);
        font.draw(spriteBatch, text, position.x, position.y);
    }
}
