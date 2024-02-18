package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import joykeeper.towerdefense.Commands.ChangeSceneCommand;
import joykeeper.towerdefense.Commands.DeleteLevelCommand;
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
    Button deleteLevelButton;
    MyLabel levelNameLabel;
    Vector position;

    String map;
    PreviewField field;
    public LevelPreview(Vector position, String levelName){
        this.position = position;
        levelPhotoButton = new Button("", this.position, new Vector(150, 120), Color.BROWN);
        deleteLevelButton = new Button("Delete",
                new Vector(this.position.x, this.position.y-levelPhotoButton.size.y/2-30/2)
                , new Vector(150, 30), Color.RED);
        deleteLevelButton.setCommand(new DeleteLevelCommand(levelName));

        levelNameLabel = new MyLabel(levelName.split("\\.lvl")[0],
                new Vector(this.position.x,this.position.y+levelPhotoButton.size.y/2-7), Color.WHITE);
        try {
            FileInputStream fileIn = new FileInputStream("levels/" + levelName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.map = (String) in.readObject();
            Player player = (Player) in.readObject();
            levelPhotoButton.setCommand(new ChangeSceneCommand(
                    new GameScene(this.map, player)
            ));
            this.field = new PreviewField(new Vector(this.position.x-levelPhotoButton.size.x/2+11,
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
