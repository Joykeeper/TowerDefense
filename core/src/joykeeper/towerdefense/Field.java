package joykeeper.towerdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import joykeeper.towerdefense.TileTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Field implements Drawable, Updateable{
    private int width;
    private int height;
    private int cellSize;
    private Vector selectedTile;
    Vector3 mousePos;
    private Map<Vector, Tile> fieldMap = new HashMap<>();
    private StartTile startTile;
    private ArrayList<RoadTile> roadTiles = new ArrayList<>();
    private String fieldString =
                            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
                            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
                            "8 8 8 8 8 8 8 Sd 8 8 8 8 0 8 8 8 " +
                            "8 8 8 8 8 8 0 1d 0 8 8 8 8 8 8 8 " +
                            "8 8 8 8 8 8 0 1d 0 8 0 8 8 8 8 8 " +
                            "8 8 8 0 8 8 0 1d 0 8 8 F 1l 8 8 8 " +
                            "8 8 8 8 8 8 0 1d 0 1r 1r 1r 1u 8 8 8 " +
                            "8 8 8 8 8 8 0 1d 0 1u 8 8 8 8 8 8 " +
                            "8 8 8 8 8 8 0 1d 0 1u 8 8 8 8 8 8 " +
                            "8 8 0 8 8 8 0 1r 1r 1u 8 8 8 8 8 8 " +
                            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
                            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 ";



    public Field(String fieldString, int width, int height, int cellSize, Vector3 mousePos){
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;

        if (fieldString == null){
            this.fieldMap = formAMap(this.fieldString);
        } else {
            this.fieldString = fieldString;
            this.fieldMap = formAMap(fieldString);
        }

        this.mousePos = mousePos;

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
    }

    public Field(int width, int height, int cellSize, Vector3 mousePos){
        this(null, width, height, cellSize, mousePos);
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        for (Tile t : fieldMap.values()) {
            t.draw(shapeRenderer);
        }


        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(selectedTile.x*cellSize, selectedTile.y*cellSize, cellSize, cellSize);
    }

    @Override
    public void update(float deltaTime) {
        Vector chosenTile = new Vector((int)(mousePos.x/cellSize), (int)(mousePos.y/cellSize));
        if (Gdx.input.justTouched() && Gdx.input.isKeyPressed(Input.Keys.C)){
            this.fieldMap.put(chosenTile, new TowerTile(chosenTile));
        } else if (Gdx.input.justTouched()){
            for (Vector v: fieldMap.keySet()) {
                if (v.x == chosenTile.x && v.y == chosenTile.y){
                    this.fieldMap.get(v).onTileClick();
                }
            }
        }
        this.selectedTile = chosenTile;
    }
    private Map<Vector, Tile> formAMap(String map){
        Map<Vector, Tile> field = new HashMap<>();
        String[] mapArr = map.split(" ");
        int i = 0;
        for (int y = height-1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                Tile tile = new VoidTile(new Vector(x, y));

                if (mapArr[i].equals("0")){
                    tile = new TowerTile(new Vector(x, y));
                }
                else if(mapArr[i].contains("S")){
                    if (mapArr[i].contains("d")) startTile = new StartTile(new Vector(x, y), new Vector(x, y-1));
                    else if (mapArr[i].contains("u")) startTile = new StartTile(new Vector(x, y), new Vector(x, y+1));
                    else if (mapArr[i].contains("r")) startTile = new StartTile(new Vector(x, y), new Vector(x+1, y));
                    else if (mapArr[i].contains("l")) startTile = new StartTile(new Vector(x, y), new Vector(x-1, y-1));
                    tile = startTile;
                }
                else if(mapArr[i].equals("F")){
                    tile = new StopTile(new Vector(x, y));
                }
                else if(mapArr[i].contains("1")){
                    if (mapArr[i].contains("d")) {
                        RoadTile rTile = new RoadTile(new Vector(x, y), new Vector(x, y-1));
                        roadTiles.add(rTile);
                        tile = rTile;
                    }else if (mapArr[i].contains("u")) {
                        RoadTile rTile = new RoadTile(new Vector(x, y), new Vector(x, y+1));
                        roadTiles.add(rTile);
                        tile = rTile;
                    }else if (mapArr[i].contains("r")) {
                        RoadTile rTile = new RoadTile(new Vector(x, y), new Vector(x+1, y));
                        roadTiles.add(rTile);
                        tile = rTile;
                    }else if (mapArr[i].contains("l")) {
                        RoadTile rTile = new RoadTile(new Vector(x, y), new Vector(x-1, y));
                        roadTiles.add(rTile);
                        tile = rTile;
                    }

                }

                field.put(new Vector(x, y), tile);
                i++;
            }
        }
        return field;
    }

    public ArrayList<Vector> getRoad(){
        ArrayList<Vector> road = new ArrayList<>();
        road.add(startTile.getPosition().mul(TowerDefenseGame.instance.CELL_SIZE).add(
                new Vector(TowerDefenseGame.instance.CELL_SIZE/2, TowerDefenseGame.instance.CELL_SIZE/2)));
        Vector v = startTile.directsTo;

        boolean found;
        while (true){
            found = false;
            road.add(v.mul(TowerDefenseGame.instance.CELL_SIZE).add(
                    new Vector(TowerDefenseGame.instance.CELL_SIZE/2, TowerDefenseGame.instance.CELL_SIZE/2)));
            for (RoadTile rT: roadTiles){
                if (rT.getPosition().x == v.x && rT.getPosition().y == v.y){
                    v = rT.directsTo;
                    found = true;
                    break;
                }
            }
            if (!found) break;
        }

        return road;
    }
    public String getFieldString(){
        return this.fieldString;
    }
}
