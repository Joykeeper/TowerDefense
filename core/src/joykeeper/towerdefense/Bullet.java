package joykeeper.towerdefense;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.EnemyTypes.Enemy;

public class Bullet implements Updateable, Drawable{
    private Vector position;
    private float damage;
    private int speed = 400;
    private int size;
    private Color skin;
    private Enemy entityTarget;
    public boolean toDestroy = false;

    public Bullet(Vector position, int size, int damage, Color color, Enemy entityTarget){
        this.position = position;
        this.size = size;
        this.skin = color;
        this.damage = damage;
        this.entityTarget = entityTarget;

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(this.skin);
        shapeRenderer.circle(this.position.x, this.position.y ,this.size);
    }

    @Override
    public void update(float deltaTime) {
        checkOnEntityCollision();
        if (entityTarget.isDead()){
            this.toDestroy = true;
        }
        Vector direction = entityTarget.getPosition().sub(this.position).normalized();
        this.position = this.position.add(direction.mul(this.speed * deltaTime));
    }
    public void checkOnEntityCollision(){
        if ((Math.abs(this.position.x - entityTarget.getPosition().x) <= TowerDefenseGame.instance.CELL_SIZE/2)&&
                    (Math.abs(this.position.y - entityTarget.getPosition().y) <= TowerDefenseGame.instance.CELL_SIZE/2)){
            entityTarget.receiveDamage(this.damage);
            this.toDestroy = true;
        }
    }
}
