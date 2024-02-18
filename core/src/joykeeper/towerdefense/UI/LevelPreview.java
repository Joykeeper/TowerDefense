package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Commands.ChangeSceneCommand;
import joykeeper.towerdefense.Drawable;
import joykeeper.towerdefense.Player;
import joykeeper.towerdefense.PreviewField;
import joykeeper.towerdefense.Scenes.GameScene;
import joykeeper.towerdefense.Vector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LevelPreview implements Drawable, DrawableUI {
    Button levelPhotoButton;
    Vector position;

    String map;
    PreviewField field;
    public LevelPreview(Vector position, String levelName){
        this.position = position;
        levelPhotoButton = new Button(levelName, this.position, new Vector(128, 96), Color.PINK);

        try {
            FileInputStream fileIn = new FileInputStream("levels/" + levelName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.map = (String) in.readObject();
            levelPhotoButton.setCommand(new ChangeSceneCommand(
                    new GameScene(this.map, new Player(1000, 10))
            ));
            this.field = new PreviewField(new Vector(this.position.x-levelPhotoButton.size.x/2,
                    this.position.y-levelPhotoButton.size.y/2), this.map,16,12,8);
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("File not found: " + levelName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void draw(ShapeRenderer shapeRenderer) {
    }

    @Override
    public void drawUI(SpriteBatch spriteBatch) {
    }
}
