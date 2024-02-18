package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import joykeeper.towerdefense.WaveController;

public class CurrentWaveLabel implements DrawableUI{
    WaveController waveController;
    BitmapFont font = new BitmapFont();
    public CurrentWaveLabel(WaveController waveController){
        this.waveController = waveController;
    }
    @Override
    public void drawUI(SpriteBatch spriteBatch) {
        font.setColor(Color.BLACK);
        font.draw(spriteBatch, "Wave: " + (waveController.getCurrentWave()) + " / " +
                        waveController.getWaves().length, 700, 400);
    }
}
