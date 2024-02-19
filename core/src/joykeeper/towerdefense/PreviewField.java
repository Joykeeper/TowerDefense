package joykeeper.towerdefense;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.tileTypes.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PreviewField implements Drawable{
    private int width;
    private int height;
    private int cellSize;
    private StartTile startTile;
    private Vector position;
    private String map;
    public PreviewField(Vector position, String fieldString, int width, int height, int cellSize){
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;

        this.position = position;
        this.map = fieldString;

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
    }
    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        drawAMap(shapeRenderer);
    }

    private Map<Vector, Tile> drawAMap(ShapeRenderer sR){
        Map<Vector, Tile> field = new HashMap<>();
        String[] mapArr = map.split(" ");
        System.out.println(Arrays.toString(mapArr));
        int i = 0;
        for (int y = height-1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {

                if (mapArr[i].equals("0")){
                    drawTile(TileType.TOWER, new Vector(x, y).mul(this.cellSize).add(this.position), sR);

                }
                else if(mapArr[i].contains("S")){
                    drawTile(TileType.START, new Vector(x, y).mul(this.cellSize).add(this.position), sR);
                }
                else if(mapArr[i].equals("F")){
                    drawTile(TileType.STOP, new Vector(x, y).mul(this.cellSize).add(this.position), sR);

                }
                else if(mapArr[i].contains("1")){
                    drawTile(TileType.ROAD, new Vector(x, y).mul(this.cellSize).add(this.position), sR);
                } else {
                    drawTile(TileType.VOID, new Vector(x, y).mul(this.cellSize).add(this.position), sR);
                }
                i++;
            }
        }
        return field;
    }

    public void drawTile(TileType tt, Vector pos, ShapeRenderer sR){
        switch (tt){
            case TOWER:
                sR.setColor(Color.YELLOW);
                sR.rect(pos.x, pos.y, this.cellSize, this.cellSize);
                break;
            case VOID:
                sR.setColor(Color.GRAY);
                sR.rect(pos.x, pos.y, this.cellSize, this.cellSize);
                break;
            case ROAD:
                sR.setColor(Color.GREEN);
                sR.rect(pos.x, pos.y, this.cellSize, this.cellSize);
                break;
            case START:
                sR.setColor(Color.BLUE);
                sR.rect(pos.x, pos.y, this.cellSize, this.cellSize);
                break;
            case STOP:
                sR.setColor(Color.BLACK);
                sR.rect(pos.x, pos.y, this.cellSize, this.cellSize);
                break;
        }
    }

}
