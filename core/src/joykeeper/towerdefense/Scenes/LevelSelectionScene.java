package joykeeper.towerdefense.Scenes;

import joykeeper.towerdefense.UI.LevelPreview;
import joykeeper.towerdefense.Vector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LevelSelectionScene extends Scene{
    ArrayList<String> levelsNames = new ArrayList<>();
    public LevelSelectionScene(){
        File folder = new File("levels");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                levelsNames.add(listOfFiles[i].getName());
                System.out.println("File " + listOfFiles[i].getName());
            }
        }
    }
    @Override
    public void start() {
        for (int i = 0; i < levelsNames.size(); i++) {
            new LevelPreview(new Vector(((i%5)*148)+100, 420-(i/5)*120), levelsNames.get(i));
        }
    }
}
