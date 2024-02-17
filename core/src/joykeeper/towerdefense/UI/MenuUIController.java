package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Commands.ChangeSceneCommand;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.Player;
import joykeeper.towerdefense.Scenes.GameScene;
import joykeeper.towerdefense.Scenes.MenuScene;
import joykeeper.towerdefense.Scenes.Scene;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Vector;

import java.util.ArrayList;

public class MenuUIController implements Drawable {
    ArrayList<Button> uiElements = new ArrayList<>();
    public MenuUIController(){
        Button chooseMapButton = new Button("Choose map", new Vector(210, 220), new Vector(150, 150));
        Button createMapButton = new Button("Create map", new Vector(590, 220), new Vector(150, 150));


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
        chooseMapButton.setCommand(new ChangeSceneCommand(new GameScene(
                fieldString, new Player(500, 10)
        )));
        createMapButton.setCommand(new ChangeSceneCommand(new MenuScene()));

        uiElements.add(chooseMapButton);
        uiElements.add(createMapButton);
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(0, 0, 800, 480);
        for (Button uiElem :uiElements) {
            uiElem.draw(shapeRenderer);
        }
    }
}
