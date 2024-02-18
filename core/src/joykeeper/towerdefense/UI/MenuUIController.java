package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Commands.ChangeSceneCommand;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.Player;
import joykeeper.towerdefense.Scenes.*;
import joykeeper.towerdefense.TowerDefenseGame;
import joykeeper.towerdefense.Vector;

import java.util.ArrayList;

public class MenuUIController implements Drawable {
    ArrayList<Button> uiElements = new ArrayList<>();
    public MenuUIController(){
        Button chooseMapButton = new Button("Choose map", new Vector(210, 320), new Vector(150, 150));
        Button playDefaultMap = new Button("Play default map", new Vector(400, 120), new Vector(150, 150));
        Button createMapButton = new Button("Create map", new Vector(590, 320), new Vector(150, 150));

        chooseMapButton.setCommand(new ChangeSceneCommand(new LevelSelectionScene()));
        createMapButton.setCommand(new ChangeSceneCommand(new LevelCreationScene()));
        playDefaultMap.setCommand(new ChangeSceneCommand(new GameScene(
                new Player(500, 10)
        )));

        uiElements.add(chooseMapButton);
        uiElements.add(createMapButton);
        uiElements.add(playDefaultMap);
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
