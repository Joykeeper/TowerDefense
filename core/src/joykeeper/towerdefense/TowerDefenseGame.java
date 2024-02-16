package joykeeper.towerdefense;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import joykeeper.towerdefense.EnemySelectors.ClosestEnemySelector;
import joykeeper.towerdefense.EnemySelectors.FirstEnemySelector;
import joykeeper.towerdefense.EnemyTypes.*;
import joykeeper.towerdefense.TowerTypes.*;
import joykeeper.towerdefense.UI.UIController;

import java.util.ArrayList;

public class TowerDefenseGame extends Game {
	public static TowerDefenseGame instance;

	SpriteBatch spriteBatch;
	OrthographicCamera camera;
	public Vector3 mousePosition = new Vector3(0,0,0);
	ShapeRenderer shapeRenderer;
	SceneManager sceneManager;
	public EnemyController enemyController;
	UIController uiController;
	Field field;
	Player player;
	public PanelHolder panelHolder;
	public ArrayList<Bullet> bullets = new ArrayList<>();
	ArrayList<Updateable> updatables = new ArrayList<>();
	ArrayList<Drawable> drawables = new ArrayList<>();
	ArrayList<Object> objectsToRemove = new ArrayList<>();

	ArrayList<Updateable> newUpdatables = new ArrayList<>();
	ArrayList<Drawable> newDrawables = new ArrayList<>();
	public final int CELL_SIZE = 40;

	@Override
	public void create () {
		instance = this;

		spriteBatch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		shapeRenderer = new ShapeRenderer();

		sceneManager = new SceneManager();

		field = new Field(16, 12, 40, mousePosition);
		player = new Player(1000, 10);
		panelHolder = new PanelHolder();
		uiController = new UIController(player);
		enemyController = new EnemyController(field.getRoad());

		updatables.add(panelHolder);

		updatables.add(enemyController);

		updatables.add(field);
		drawables.add(field);
	}

	@Override
	public void render () {
		addToListDestroyedObjects();

		for (Updateable updateable: updatables) {
			updateable.update(Gdx.graphics.getDeltaTime());
		}


		ScreenUtils.clear(1, 1, 1, 1);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		for (Drawable drawable : drawables) {
			drawable.draw(shapeRenderer);
		}

		shapeRenderer.end();

		updatables.addAll(newUpdatables);
		newUpdatables.clear();

		drawables.addAll(newDrawables);
		newDrawables.clear();


		for (Object o : this.objectsToRemove) {
			this.removeObject(o);
		}




		spriteBatch.setProjectionMatrix(camera.combined); //or your matrix to draw GAME WORLD, not UI

		spriteBatch.begin();

		uiController.draw(spriteBatch);

		spriteBatch.end();



		camera.update();

		mousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		camera.unproject(mousePosition);
	}

	public void addUpdatable(Updateable updateable){
		newUpdatables.add(updateable);
	}

	public void addDrawable(Drawable drawable){
		newDrawables.add(drawable);
	}
	public Tower spawnTower(int x, int y, TowerType towerType){
		Tower tower;
		switch (towerType){
			case FAST:
				tower = new FastTower(new Vector(x, y), this.enemyController.enemies, new FirstEnemySelector());
				break;
			case SNIPER:
				tower = new SniperTower(new Vector(x, y), this.enemyController.enemies, new FirstEnemySelector());
				break;
			default:
				tower = new BasicTower(new Vector(x, y), this.enemyController.enemies, new ClosestEnemySelector());
		}

		if (player.getMoney() - tower.getCost() < 0){
			return null;
		}

		player.spendMoney(tower.getCost());

		addDrawable(tower);
		addUpdatable(tower);
		return tower;
	}
	private void addToListDestroyedObjects(){
		for (int i = 0; i < this.bullets.size(); i++) {
			if(bullets.get(i).toDestroy){
				addObjectToRemove(bullets.get(i));
			}
		}
	}
	public void addObjectToRemove(Object obj){
		objectsToRemove.add(obj);
	}
	private void removeObject(Object obj){
		updatables.remove(obj);
		drawables.remove(obj);
		bullets.remove(obj);
	}

}
