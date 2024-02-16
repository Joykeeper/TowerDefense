package joykeeper.towerdefense.TowerTypes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.*;
import joykeeper.towerdefense.EnemySelectors.EnemySelector;
import joykeeper.towerdefense.EnemyTypes.Enemy;

import java.util.ArrayList;





public class Tower implements Updateable, Drawable {
    private Vector position;
    private float SHOOTING_RATE;
    int BULLET_DAMAGE;
    private float shootCD = 0;
    private Enemy target;
    private ArrayList<Enemy> allEnemies;
    private int shootingRadius;
    private EnemySelector enemySelector;
    private int cost;
    private Color skin;

    public Tower(
            Vector position,
            int damage,
            float shootingRate,
            int shootingRadius,
            ArrayList<Enemy> enemies,
            EnemySelector enemySelector,
            Color skin,
            int cost
    ){
        this.position = position;
        this.BULLET_DAMAGE = damage;
        this.SHOOTING_RATE = shootingRate;
        this.shootingRadius = shootingRadius;
        this.allEnemies = enemies;
        this.enemySelector = enemySelector;
        this.cost = cost;
        this.skin = skin;
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(this.skin);
        shapeRenderer.circle(this.position.x * TowerDefenseGame.instance.CELL_SIZE+20,
                this.position.y*TowerDefenseGame.instance.CELL_SIZE+20,
                TowerDefenseGame.instance.CELL_SIZE/2);

        shapeRenderer.end();
        
        //transparent visibility zone
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(0, 0, 0, 0.1f);
        shapeRenderer.circle(this.position.x*TowerDefenseGame.instance.CELL_SIZE+20,
                this.position.y*TowerDefenseGame.instance.CELL_SIZE+20, this.shootingRadius);
        shapeRenderer.end();
        
        Gdx.gl.glDisable(GL20.GL_BLEND);
        
        
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

    }

    @Override
    public void update(float deltaTime) {
        target = enemySelector.select(this, getVisibleEnemies());
        if (this.shootCD <= 0 && target != null){
            this.shoot();
            this.shootCD = this.SHOOTING_RATE;
        }
        this.shootCD -= deltaTime;
    }

    private void shoot(){
        Bullet bullet = new Bullet(new Vector(this.position.x*TowerDefenseGame.instance.CELL_SIZE+20,
                this.position.y*TowerDefenseGame.instance.CELL_SIZE+20),
                10, this.BULLET_DAMAGE, Color.RED, target);
        TowerDefenseGame.instance.bullets.add(bullet);
        TowerDefenseGame.instance.addDrawable(bullet);
        TowerDefenseGame.instance.addUpdatable(bullet);
    }

    private ArrayList<Enemy> getVisibleEnemies(){
        ArrayList<Enemy> visibleEnemies = new ArrayList<>();
        for (Enemy e : this.allEnemies) {
            float circlePosX = this.position.x*TowerDefenseGame.instance.CELL_SIZE+20;
            float circlePosY = this.position.y*TowerDefenseGame.instance.CELL_SIZE+20;
            if (e.getPosition().x <= circlePosX+shootingRadius &&
                    e.getPosition().x >= circlePosX-shootingRadius){
                if (e.getPosition().y <= circlePosY+shootingRadius &&
                        e.getPosition().y >= circlePosY-shootingRadius){
                    visibleEnemies.add(e);
                }
            }
        }
        return visibleEnemies;
    }
    public Vector getTilePos(){
        return this.position;
    }
    public Vector getPixelPos(){
        return this.position.mul(TowerDefenseGame.instance.CELL_SIZE);
    }
    public int getCost(){
        return this.cost;
    }
}
