package joykeeper.towerdefense;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import joykeeper.towerdefense.scenes.MenuScene;
import joykeeper.towerdefense.ui.DrawableUI;

import java.util.ArrayList;

public class TowerDefenseGame extends Game {
	public static TowerDefenseGame instance;

	SpriteBatch spriteBatch;
	OrthographicCamera camera;
	public Vector3 mousePosition = new Vector3(0,0,0);
	ShapeRenderer shapeRenderer;
	public SceneManager sceneManager;
	public ArrayList<Bullet> bullets = new ArrayList<>();
	ArrayList<Updateable> updatables = new ArrayList<>();
	ArrayList<Drawable> drawables = new ArrayList<>();
	ArrayList<DrawableUI> drawableUIs = new ArrayList<>();
	ArrayList<Object> objectsToRemove = new ArrayList<>();

	ArrayList<Updateable> newUpdatables = new ArrayList<>();
	ArrayList<Drawable> newDrawables = new ArrayList<>();
	ArrayList<DrawableUI> newDrawableUIs = new ArrayList<>();
	public final int CELL_SIZE = 40;

	@Override
	public void create () {
		instance = this;

		spriteBatch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		shapeRenderer = new ShapeRenderer();


		String fieldString =
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

		sceneManager = new SceneManager();
		sceneManager.setScene(new MenuScene());

	}

	@Override
	public void render () {
		sceneManager.getCurrentScene().update(Gdx.graphics.getDeltaTime());

		ScreenUtils.clear(1, 1, 1, 1);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		sceneManager.getCurrentScene().draw(shapeRenderer);
		shapeRenderer.end();

		spriteBatch.setProjectionMatrix(camera.combined);

		spriteBatch.begin();
		sceneManager.getCurrentScene().drawUI(spriteBatch);
		spriteBatch.end();

		sceneManager.getCurrentScene().addNewObjects();


		camera.update();

		mousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(mousePosition);

	}

}
