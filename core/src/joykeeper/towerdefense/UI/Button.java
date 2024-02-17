package joykeeper.towerdefense.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import joykeeper.towerdefense.Commands.Command;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.Scenes.GameScene;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Updateable;
import joykeeper.towerdefense.Vector;

public class Button implements Updateable, Drawable {
    Vector3 mousePos;
    Vector position;
    Vector size;
    MyLabel label;
    protected Command command;
    boolean selected = false;
    public Button(String text, Vector position, Vector size){
        this.position = position;
        this.size = size;
        this.label = new MyLabel(text, position);
        this.mousePos = TowerDefenseGame.instance.mousePosition;

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
    }
    @Override
    public void update(float deltaTime) {

        this.selected = (mousePos.x >= this.position.x - size.x/2 && mousePos.x <= this.position.x + size.x/2)
                && (mousePos.y >= this.position.y - size.y/2 && mousePos.y <= this.position.y + size.y/2);

        if (Gdx.input.justTouched()){
            if (this.selected){
                this.executeCommand();
            }
        }
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        if(this.selected){
            shapeRenderer.setColor(Color.BLUE);
        } else {
            shapeRenderer.setColor(Color.GRAY);
        }
        shapeRenderer.rect(position.x-size.x/2, position.y-size.y/2, this.size.x, this.size.y);
    }
    public void setCommand(Command command){
        this.command = command;
    }

    public void executeCommand(){
        this.command.execute();
    }
}
