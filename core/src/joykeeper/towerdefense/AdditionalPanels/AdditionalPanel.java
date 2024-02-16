package joykeeper.towerdefense.AdditionalPanels;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Updateable;

public class AdditionalPanel implements Drawable, Updateable {
    boolean destroyed;
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(640, 0,
                160,
                480);
    }

    @Override
    public void update(float deltaTime) {

    }
}
