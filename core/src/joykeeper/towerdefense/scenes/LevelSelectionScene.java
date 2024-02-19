package joykeeper.towerdefense.scenes;

import joykeeper.towerdefense.ui.LevelPreview;
import joykeeper.towerdefense.Vector;

import java.io.File;
import java.util.ArrayList;

public class LevelSelectionScene extends Scene{
    ArrayList<String> levelsNames = new ArrayList<>();
    public LevelSelectionScene(){
        File folder = new File("levels");
        System.out.println(folder.exists());

        if (!folder.exists()) folder.mkdirs();;

        System.out.println(folder.exists());
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                levelsNames.add(listOfFiles[i].getName());
            }
        }
    }
    @Override
    public void start() {
        for (int i = 0; i < levelsNames.size(); i++) {
            new LevelPreview(new Vector(((i%4)*160)+175, 420-(i/4)*160), levelsNames.get(i));
        }
    }
}
