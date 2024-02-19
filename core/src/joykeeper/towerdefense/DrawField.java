package joykeeper.towerdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import joykeeper.towerdefense.tileTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DrawField implements Drawable, Updateable{
    private int width;
    private int height;
    private int cellSize;
    private Vector selectedTile;
    private TileType drawingTile = TileType.ROAD;
    Vector3 mousePos;
    private Map<Vector, Tile> fieldMap = new HashMap<>();
    private String fieldString =
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 1 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 " +
            "8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 ";
    private StartTile startTile;



    public DrawField(String fieldString, int width, int height, int cellSize, Vector3 mousePos){
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;

        if (fieldString == null){
            setFieldMap(this.fieldString);
        } else {
            this.fieldString = fieldString;
            this.fieldMap = formAMap(fieldString);
        }

        this.mousePos = mousePos;

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
    }

    public DrawField(int width, int height, int cellSize, Vector3 mousePos){
        this(null, width, height, cellSize, mousePos);
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        for (Tile t : this.fieldMap.values()) {
            t.draw(shapeRenderer);
        }

        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(selectedTile.x*cellSize, selectedTile.y*cellSize, cellSize, cellSize);
    }

    @Override
    public void update(float deltaTime) {
        Vector chosenTile = new Vector((int)(mousePos.x/cellSize), (int)(mousePos.y/cellSize));
        if (Gdx.input.isTouched()){
            for (Vector v: fieldMap.keySet()) {
                if (v.x == chosenTile.x && v.y == chosenTile.y){
                    switch (this.drawingTile){
                        case ROAD_R:
                            this.fieldMap.put(v, new RoadTile(v, new Vector(1, 0)));
                            break;
                        case ROAD_L:
                            this.fieldMap.put(v, new RoadTile(v, new Vector(-1, 0)));
                            break;
                        case ROAD_U:
                            this.fieldMap.put(v, new RoadTile(v, new Vector(0, 1)));
                            break;
                        case ROAD_D:
                            this.fieldMap.put(v, new RoadTile(v, new Vector(0, -1)));
                            break;

                        case START_R:
                            this.fieldMap.put(v, new StartTile(v, new Vector(1, 0)));
                            break;
                        case START_L:
                            this.fieldMap.put(v, new StartTile(v, new Vector(-1, 0)));
                            break;
                        case START_U:
                            this.fieldMap.put(v, new StartTile(v, new Vector(0, 1)));
                            break;
                        case START_D:
                            this.fieldMap.put(v, new StartTile(v, new Vector(0, -1)));
                            break;

                        case VOID:
                            this.fieldMap.put(v, new VoidTile(v));
                            break;
                        case TOWER:
                            this.fieldMap.put(v, new TowerTile(v));
                            break;
                        case STOP:
                            this.fieldMap.put(v, new StopTile(v));
                            break;
                    }
                }
            }
        }


        this.selectedTile = chosenTile;
    }
    private Map<Vector, Tile> formAMap(String map){
        Map<Vector, Tile> field = new HashMap<>();
        String[] mapArr = map.split(" ");
        System.out.println(Arrays.toString(mapArr));
        int i = 0;
        for (int y = height-1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                Tile tile = new VoidTile(new Vector(x, y));

                if (mapArr[i].equals("0")){
                    tile = new TowerTile(new Vector(x, y));
                }
                else if(mapArr[i].contains("S")){
                    if (mapArr[i].contains("d")) {
                        startTile = new StartTile(new Vector(x, y), new Vector(0, -1));
                    }
                    else if (mapArr[i].contains("u")) {
                        startTile = new StartTile(new Vector(x, y), new Vector(0, 1));
                    }
                    else if (mapArr[i].contains("r")){
                        startTile = new StartTile(new Vector(x, y), new Vector(1, 0));
                    }
                    else if (mapArr[i].contains("l")) {
                        startTile = new StartTile(new Vector(x, y), new Vector(-1, 0));
                    }
                    tile = startTile;
                }
                else if(mapArr[i].equals("F")){
                    tile = new StopTile(new Vector(x, y));
                }
                else if(mapArr[i].contains("1")){
                    if (mapArr[i].contains("d")) {
                        RoadTile rTile = new RoadTile(new Vector(x, y), new Vector(0, -1));
                        tile = rTile;
                    }else if (mapArr[i].contains("u")) {
                        RoadTile rTile = new RoadTile(new Vector(x, y), new Vector(0, 1));
                        tile = rTile;
                    }else if (mapArr[i].contains("r")) {
                        RoadTile rTile = new RoadTile(new Vector(x, y), new Vector(1, 0));
                        tile = rTile;
                    }else if (mapArr[i].contains("l")) {
                        RoadTile rTile = new RoadTile(new Vector(x, y), new Vector(-1, 0));
                        tile = rTile;
                    }

                }

                field.put(new Vector(x, y), tile);
                i++;
            }
        }
        return field;
    }
    private String mapToString(){
        StringBuilder map = new StringBuilder();
        for (int y = height-1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                for (Vector v : this.fieldMap.keySet()) {
                    if(v.x == x && v.y == y) {
                        if (this.fieldMap.get(v) instanceof TowerTile){
                            map.append("0 ");
                        } else if (this.fieldMap.get(v) instanceof VoidTile) {
                            map.append("8 ");
                        } else if (this.fieldMap.get(v) instanceof StartTile) {
                            StartTile sT = (StartTile) this.fieldMap.get(v);
                            if (sT.directsTo.x == 0 && sT.directsTo.y == 1){
                                map.append("Su ");
                            } else if (sT.directsTo.x == 0 && sT.directsTo.y == -1){
                                map.append("Sd ");
                            }else if (sT.directsTo.x == 1 && sT.directsTo.y == 0){
                                map.append("Sr ");
                            }else if (sT.directsTo.x == -1 && sT.directsTo.y == 0){
                                map.append("Sl ");
                            }
                        } else if (this.fieldMap.get(v) instanceof RoadTile) {
                            RoadTile roadT = (RoadTile) this.fieldMap.get(v);
                            if (roadT.directsTo.x == 0 && roadT.directsTo.y == 1){
                                map.append("1u ");
                            } else if (roadT.directsTo.x == 0 && roadT.directsTo.y == -1){
                                map.append("1d ");
                            }else if (roadT.directsTo.x == 1 && roadT.directsTo.y == 0){
                                map.append("1r ");
                            }else if (roadT.directsTo.x == -1 && roadT.directsTo.y == 0){
                                map.append("1l ");
                            }
                        } else if(this.fieldMap.get(v) instanceof StopTile){
                            map.append("F ");
                        }
                        break;
                    }
                }
            }
        }
        return map.toString();
    }
    public String getFieldString(){
        return mapToString();
    }
    public void setFieldMap(String map){
        this.fieldMap = formAMap(map);
    }
    public void setDrawingTile(TileType tt){
        this.drawingTile = tt;
    }
    public boolean isMapWorking(){
        int amountOfStart = 0;
        StartTile startTile = null;
        Vector stopPos = new Vector(0, 0);
        int amountOfFinish = 0;
        for (Tile t: fieldMap.values()){
            if(t instanceof StartTile){
                startTile = (StartTile) t;
                amountOfStart++;
            } else if (t instanceof StopTile){
                stopPos = t.getPosition();
                amountOfFinish++;
            }
        }
        if(!(amountOfStart==1 && amountOfFinish==1)){
            return false;
        }

        if(startTile != null){
            Vector lastTilePos = getLastTilePos(startTile);

            if (lastTilePos.x == stopPos.x &&
                lastTilePos.y == stopPos.y) {
                return true;
            }
        }

        return false;
    }

    public Vector getLastTilePos(StartTile startTile){
        Vector lastTilePos = startTile.getPosition().add(startTile.directsTo);
        ArrayList<RoadTile> roadTiles = getRoadTiles();
        boolean found;
        while (true){
            found = false;
            for (RoadTile rT: roadTiles){
                if (rT.getPosition().x == lastTilePos.x && rT.getPosition().y == lastTilePos.y) {
                    lastTilePos = lastTilePos.add(rT.directsTo);
                    found = true;
                    break;
                }
            }
            if (!found) break;
        }
        return lastTilePos;
    }

    public ArrayList<RoadTile> getRoadTiles(){
        ArrayList<RoadTile> roadTiles = new ArrayList<>();
        for (Tile t: fieldMap.values()){
            if(t instanceof RoadTile){
                roadTiles.add((RoadTile) t);
            }
        }
        return roadTiles;
    }
}
