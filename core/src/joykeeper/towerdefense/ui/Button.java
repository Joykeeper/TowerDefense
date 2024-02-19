package joykeeper.towerdefense.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import joykeeper.towerdefense.commands.Command;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Updateable;
import joykeeper.towerdefense.Vector;

public class Button implements Updateable, Drawable {
    Vector3 mousePos;
    Vector position;
    Vector size;
    MyLabel label;
    Color color;
    protected Command command;
    boolean selected = false;
    public boolean visible = true;
    public Button(String text, Vector position, Vector size, Color color, Color fontColor){
        this.position = position;
        this.size = size;
        this.label = new MyLabel(text, position, fontColor);
        this.color = color;
        this.mousePos = TowerDefenseGame.instance.mousePosition;

        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
    }
    public Button(String text, Vector position, Vector size, Color color){
        this(text, position, size, color, Color.BLACK);
    }

    public Button(String text, Vector position, Vector size){
        this(text, position, size, Color.GRAY, Color.BLACK);
    }
    @Override
    public void update(float deltaTime) {
        if (!this.visible){
            TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(this);
            TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(this.label);
        }

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
        shapeRenderer.setColor(this.color);
        shapeRenderer.rect(position.x-size.x/2, position.y-size.y/2, this.size.x, this.size.y);
        if (this.selected) {
            shapeRenderer.end();

            //transparent visibility zone
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

            shapeRenderer.setColor(0, 0, 0, 0.2f);
            shapeRenderer.rect(position.x-size.x/2, position.y-size.y/2, this.size.x, this.size.y);
            shapeRenderer.end();

            Gdx.gl.glDisable(GL20.GL_BLEND);


            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        }
    }
    public void setCommand(Command command){
        this.command = command;
    }

    public void executeCommand(){
        this.command.execute();
    }
    public void setVisible(boolean state){
        if(!this.visible && state){
            TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
            TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawable(this);
            TowerDefenseGame.instance.sceneManager.getCurrentScene().addDrawableUI(this.label);
        }
        this.visible = state;
    }
    public void setText(String text){
        this.label.text = text;
    }
}
