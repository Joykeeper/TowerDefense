package joykeeper.towerdefense.Commands;

import joykeeper.towerdefense.DrawField;
import joykeeper.towerdefense.Field;
import joykeeper.towerdefense.Player;

import java.io.*;

public class SaveMapCommand implements Command{
    DrawField drawField;
    Player player;
    public SaveMapCommand(DrawField drawField, Player player){
        this.drawField = drawField;
        this.player = player;
    }

    @Override
    public void execute() {
        try {
            int levelNo = 1;

            File folder = new File("levels/");
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    int fileNo = Integer.parseInt(listOfFiles[i].getName().split("\\.lvl")[0]);
                    if (fileNo > levelNo){
                        levelNo = fileNo;
                    }
                }
            }


            FileOutputStream fileOut = new FileOutputStream("levels/" + ++levelNo +".lvl");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.drawField.getFieldString());
            out.writeObject(this.player);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Map saved");
    }
}
