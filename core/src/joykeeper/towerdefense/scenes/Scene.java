package joykeeper.towerdefense.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.ui.DrawableUI;
import joykeeper.towerdefense.Updateable;

import java.util.ArrayList;

public abstract class Scene implements Updateable, Drawable, DrawableUI {
    public ArrayList<Drawable> drawables = new ArrayList<>();
    public ArrayList<DrawableUI> drawableUIs = new ArrayList<>();
    ArrayList<Updateable> newUpdatables = new ArrayList<>();
    public ArrayList<Updateable> updatables = new ArrayList<>();
    ArrayList<Drawable> newDrawables = new ArrayList<>();
    ArrayList<DrawableUI> newDrawableUIs = new ArrayList<>();
    ArrayList<Object> objectsToRemove = new ArrayList<>();

    @Override
    public void update(float deltaTime) {
        for (Updateable updateable: updatables) {
            updateable.update(Gdx.graphics.getDeltaTime());
        }

        for (Object o : this.objectsToRemove) {
            this.removeObject(o);
        }
        this.objectsToRemove.clear();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            TowerDefenseGame.instance.sceneManager.setScene(new MenuScene());
        }
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        for (Drawable drawable : drawables) {
            drawable.draw(shapeRenderer);
        }
    }
    @Override
    public void drawUI(SpriteBatch spriteBatch) {
        for (DrawableUI drawable : drawableUIs) {
            drawable.drawUI(spriteBatch);
        }
    }
    public abstract void start();
    public void addNewObjects(){
        updatables.addAll(newUpdatables);
        newUpdatables.clear();

        drawables.addAll(newDrawables);
        newDrawables.clear();

        drawableUIs.addAll(newDrawableUIs);
        newDrawableUIs.clear();
    }
    public void addUpdatable(Updateable updateable){
        newUpdatables.add(updateable);
    }

    public void addDrawable(Drawable drawable){
        newDrawables.add(drawable);
    }
    public void addDrawableUI(DrawableUI drawableUI){
        newDrawableUIs.add(drawableUI);
    }

    public void addObjectToRemove(Object obj){
        objectsToRemove.add(obj);
    }
    private void removeObject(Object obj){
        this.updatables.remove(obj);
        this.drawables.remove(obj);
        this.drawableUIs.remove(obj);
    }

}
