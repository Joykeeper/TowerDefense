package joykeeper.towerdefense.tileTypes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Vector;

public class StartTile extends Tile {
    public Vector directsTo;
    public StartTile(Vector position, Vector directsTo, Vector size){
        super(position, size);
        this.skin = Color.BLUE;
        this.directsTo = directsTo;
    }
    public StartTile(Vector position, Vector directsTo){
        super(position);
        this.skin = Color.BLUE;
        this.directsTo = directsTo;
    }

    @Override
    public void onTileClick() {
    }

    public void draw(ShapeRenderer shapeRenderer) {
        super.draw(shapeRenderer);
        Vector pos = this.position.mul(TowerDefenseGame.instance.CELL_SIZE);
        shapeRenderer.setColor(Color.BROWN);
        if (this.directsTo.x == 0 && this.directsTo.y == 1){
            shapeRenderer.triangle(pos.x, pos.y+20, pos.x+40, pos.y+20, pos.x+20,pos.y+40);
        } else if (this.directsTo.x == 0 && this.directsTo.y == -1) {
            shapeRenderer.triangle(pos.x, pos.y+20, pos.x+40, pos.y+20, pos.x+20,pos.y);
        }else if (this.directsTo.x == 1 && this.directsTo.y == 0) {
            shapeRenderer.triangle(pos.x+40, pos.y+20, pos.x+20, pos.y+40, pos.x+20,pos.y);
        }else if (this.directsTo.x == -1 && this.directsTo.y == 0) {
            shapeRenderer.triangle(pos.x, pos.y+20, pos.x+20, pos.y+40, pos.x+20,pos.y);
        }
    }
}
