package joykeeper.towerdefense.enemyTypes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Updateable;
import joykeeper.towerdefense.Vector;

public class Enemy implements Updateable, Drawable {
    private Vector[] road;
    private int desiredTileInd = 0;
    float healthPoints;
    boolean dead = false;
    boolean reachedEnd = false;
    Vector position;
    protected int moveSpeed;
    Color skin;
    public int reward;
    public Enemy(Vector[] road, int moveSpeed, float healthPoints, Color skin, int reward, int waveNo){
        this.position = road[0];
        this.road = road;
        this.moveSpeed = moveSpeed;
        this.skin = skin;
        this.reward = reward + waveNo*1;
        this.healthPoints = healthPoints*(1f+waveNo/10f);

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
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
        goToPos(road[desiredTileInd], deltaTime);
    }
    public float getHealthPoints(){return this.healthPoints;}
    public int getReward(){return this.reward;}
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
    }

    public boolean isDead() {
        return this.dead;
    }

    public boolean hasReachedEnd() {
        return reachedEnd;
    }
    public float getCurrentRoadPercentage(){
        return (float) this.desiredTileInd/ (float) this.road.length;
    }
}
