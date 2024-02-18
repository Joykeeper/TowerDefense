package joykeeper.towerdefense.AdditionalPanels;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Updateable;

public abstract class AdditionalPanel implements Drawable, Updateable {
    boolean destroyed = false;

    public AdditionalPanel(){
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
    }
    public boolean isDestroyed() {
        return this.destroyed;
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(640, 0,
                160,
                480);
    }

    @Override
    public abstract void update(float deltaTime);
}
