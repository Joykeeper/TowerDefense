package joykeeper.towerdefense.EnemyTypes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Updateable;
import joykeeper.towerdefense.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class Enemy implements Updateable, Drawable {
    private int id;
    private Vector[] road;
    private int desiredTileInd = 0;
    float healthPoints;
    boolean dead = false;
    boolean reachedEnd = false;
    Vector position;
    protected int moveSpeed;
    Color skin;
    public int reward;
    public Enemy(int id, Vector[] road, int moveSpeed, float healthPoints, Color skin, int reward){
        this.id = id;
        this.position = road[0];
        this.road = road;
        this.moveSpeed = moveSpeed;
        this.skin = skin;
        this.reward = reward;
        this.healthPoints = healthPoints;
        for (Vector v : road) {
            System.out.println(v.x + " " + v.y);
        }
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(this.skin);
        shapeRenderer.rect(this.position.x - TowerDefenseGame.instance.CELL_SIZE/2,
                this.position.y - TowerDefenseGame.instance.CELL_SIZE/2,
                TowerDefenseGame.instance.CELL_SIZE, TowerDefenseGame.instance.CELL_SIZE);
    }

    @Override
    public void update(float deltaTime) {
        //checkPos();
        goToPos(road[desiredTileInd], deltaTime);
    }
    public int getId(){return this.id;}
    public float getHealthPoints(){return this.healthPoints;}
    public float getReward(){return this.reward;}
    public Vector getPosition(){return this.position;}
    public void receiveDamage(float damage){
        this.healthPoints -= damage;
        if (this.healthPoints <= 0){
            this.dead = true;
        }
    }

    public void goToPos(Vector pos, float deltaTime){
        Vector direction = this.position.sub(pos).normalized();

        if (Math.abs(pos.x - position.x) < this.moveSpeed * deltaTime
                && Math.abs(pos.y - position.y) < this.moveSpeed * deltaTime){
            if (this.desiredTileInd == road.length-1){
                this.reachedEnd = true;
            } else {
                this.desiredTileInd++;
            }
        }

        this.position = this.position.sub(direction.mul(this.moveSpeed * deltaTime));
        System.out.println(desiredTileInd);
    }

    public boolean isDead() {
        return this.dead;
    }

    public boolean hasReachedEnd() {
        return reachedEnd;
    }
}
