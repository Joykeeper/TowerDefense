package joykeeper.towerdefense.Commands;

import com.badlogic.gdx.Gdx;
import joykeeper.towerdefense.DrawField;
import joykeeper.towerdefense.Player;
import joykeeper.towerdefense.Scenes.GameScene;
import joykeeper.towerdefense.UI.PlayerStatsSettingSection;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class LoadMapCommand implements Command{
    DrawField drawField;
    Player player;
    PlayerStatsSettingSection playerStatsSettingSection;
    public LoadMapCommand(DrawField drawField, Player player, PlayerStatsSettingSection playerStatsSettingSection){
        this.drawField = drawField;
        this.player = player;
        this.playerStatsSettingSection = playerStatsSettingSection;
    }
    @Override
    public void execute() {

        // load file check

        JFileChooser jFileChooser = new JFileChooser(Gdx.files.getLocalStoragePath()+ "/levels");
        int returnVal = jFileChooser.showSaveDialog(null);
        if (!(returnVal == JFileChooser.APPROVE_OPTION)){
            System.out.println("File load cancelled");
            return;
        }
        String fileToLoad = jFileChooser.getSelectedFile().getName();

        Pattern p = Pattern.compile("\\d+\\.lvl");
        Matcher m = p.matcher(fileToLoad);
        if(!m.matches()){
            System.out.println("Wrong file");
            return;
        }

        // loading level
        try {
            FileInputStream fileIn = new FileInputStream("levels/" + fileToLoad);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            String map = (String) in.readObject();
            this.player = (Player) in.readObject();
            playerStatsSettingSection.updatePlayerStats(player);
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
    }
}
