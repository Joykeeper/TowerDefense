package joykeeper.towerdefense.tileTypes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Vector;

public abstract class Tile implements Drawable {
    protected Vector position;
    protected Vector size;
    protected Color skin;
    public Tile(Vector position, Vector size){
        this.position = position;
        this.size = size;
    }
    public Tile(Vector position){
        this(position,new Vector(TowerDefenseGame.instance.CELL_SIZE, TowerDefenseGame.instance.CELL_SIZE));
    }
    abstract public void onTileClick();
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(skin);
        shapeRenderer.rect(this.position.x * this.size.x,
                this.position.y* this.size.y, this.size.x, this.size.x);
    }
    public Vector getPosition() {return this.position;}
}
