package joykeeper.towerdefense.AdditionalPanels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TileTypes.TowerTile;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.TowerTypes.TowerType;
import joykeeper.towerdefense.Updateable;

public class TowerSelectionPanel extends AdditionalPanel implements Drawable, Updateable {
    Vector3 mousePos;
    TowerTile towerTile;
    public TowerSelectionPanel(TowerTile towerTile){
        this.mousePos = TowerDefenseGame.instance.mousePosition;
        this.towerTile = towerTile;
        System.out.println(towerTile.getPosition().x + " " + towerTile.getPosition().y);
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        super.draw(shapeRenderer);
        shapeRenderer.setColor(Color.LIME);
        shapeRenderer.circle(720,
                300,
                TowerDefenseGame.instance.CELL_SIZE);

        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.circle(720,
                200,
                TowerDefenseGame.instance.CELL_SIZE);

        shapeRenderer.setColor(Color.CORAL);
        shapeRenderer.circle(720,
                100,
                TowerDefenseGame.instance.CELL_SIZE);
    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.justTouched()){
            if(((mousePos.x - 720)*(mousePos.x - 720) +
                    (mousePos.y - 300)*(mousePos.y - 300) <= TowerDefenseGame.instance.CELL_SIZE*
                    TowerDefenseGame.instance.CELL_SIZE)){
                towerTile.spawnTower(TowerType.BASIC);
                super.destroyed = true;
            } else if(((mousePos.x - 720)*(mousePos.x - 720) +
                    (mousePos.y - 200)*(mousePos.y - 200) <= TowerDefenseGame.instance.CELL_SIZE*
                    TowerDefenseGame.instance.CELL_SIZE)){
                towerTile.spawnTower(TowerType.FAST);
                super.destroyed = true;
            } else if(((mousePos.x - 720)*(mousePos.x - 720) +
                    (mousePos.y - 100)*(mousePos.y - 100) <= TowerDefenseGame.instance.CELL_SIZE*
                    TowerDefenseGame.instance.CELL_SIZE)){
                towerTile.spawnTower(TowerType.SNIPER);
                super.destroyed = true;
            }
        }
    }


}
