package joykeeper.towerdefense.Commands;

import joykeeper.towerdefense.DrawField;
import joykeeper.towerdefense.Field;

import java.io.*;

public class SaveMapCommand implements Command{
    DrawField drawField;
    public SaveMapCommand(DrawField drawField){
        this.drawField = drawField;
    }

    @Override
    public void execute() {
        try {
            FileOutputStream fileOut = new FileOutputStream("levels/1.lvl");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.drawField.getFieldString());
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        System.out.println("Map saved");
    }
}
