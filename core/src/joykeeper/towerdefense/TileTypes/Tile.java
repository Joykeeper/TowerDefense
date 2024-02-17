package joykeeper.towerdefense.TileTypes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Vector;

public abstract class Tile implements Drawable {
    protected Vector position;
    protected Color skin;
    public Tile(Vector position){
        this.position = position;

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
    }
    abstract public void onTileClick();
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(skin);
        shapeRenderer.rect(this.position.x * TowerDefenseGame.instance.CELL_SIZE,
                this.position.y* TowerDefenseGame.instance.CELL_SIZE, 40, 40);
    }
    public Vector getPosition() {return this.position;}
}
