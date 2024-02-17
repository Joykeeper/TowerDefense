package joykeeper.towerdefense.Commands;

import joykeeper.towerdefense.DrawField;

import java.io.*;

public class LoadMapCommand implements Command{
    DrawField drawField;
    public LoadMapCommand(DrawField drawField){
        this.drawField = drawField;
    }
    @Override
    public void execute() {
        try {
            FileInputStream fileIn = new FileInputStream("levels/1.lvl");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            String map = (String) in.readObject();
            this.drawField.setFieldMap(map);
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("String class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Opened directory to load from");
    }
}
