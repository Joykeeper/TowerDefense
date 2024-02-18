package joykeeper.towerdefense.TileTypes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TileTypes.Tile;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.TowerTypes.Tower;
import joykeeper.towerdefense.Vector;


public class VoidTile extends Tile implements Drawable {
    private Tower tower;
    public VoidTile(Vector position){
        super(position);
        this.skin = Color.GRAY;
    }
    public VoidTile(Vector position, Vector size){
        super(position, size);
        this.skin = Color.GRAY;
    }

    @Override
    public void onTileClick() {
        System.out.println("VoidTile");
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.GRAY);
        shapeRenderer.rect(this.position.x* TowerDefenseGame.instance.CELL_SIZE,
                this.position.y*TowerDefenseGame.instance.CELL_SIZE, 40, 40);
    }
}
