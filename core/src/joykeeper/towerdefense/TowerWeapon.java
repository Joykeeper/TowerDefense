package joykeeper.towerdefense;

import com.badlogic.gdx.graphics.Color;
import joykeeper.towerdefense.enemyTypes.Enemy;

import java.util.ArrayList;

public class TowerWeapon implements Updateable{
    public ArrayList<Bullet> bullets = new ArrayList<>();
    private Vector position;
    private final int BULLET_DAMAGE;
    public TowerWeapon(Vector position, int bulletDmg){
        this.position = position;
        this.BULLET_DAMAGE = bulletDmg;

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
    }

    @Override
    public void update(float deltaTime) {
        int removedBullets = 0;
        for (int i = 0; i < this.bullets.size()-removedBullets; i++) {
            if(this.bullets.get(i).toDestroy){
                TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(bullets.get(i));
                this.bullets.remove(this.bullets.get(i));
                removedBullets++;
            }
        }
    }
    public void shoot(Enemy target){
        Bullet bullet = new Bullet(new Vector(this.position.x*TowerDefenseGame.instance.CELL_SIZE+20,
                this.position.y*TowerDefenseGame.instance.CELL_SIZE+20),
                10, this.BULLET_DAMAGE, Color.RED, target);
        this.bullets.add(bullet);
    }
}
