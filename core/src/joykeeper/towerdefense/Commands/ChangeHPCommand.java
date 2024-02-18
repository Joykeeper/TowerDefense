package joykeeper.towerdefense.Commands;

import joykeeper.towerdefense.Player;
import joykeeper.towerdefense.UI.Button;

import javax.swing.*;

public class ChangeHPCommand implements Command{
    Button b;
    Player player;

    public ChangeHPCommand(Player player, Button button){
        this.player = player;
        this.b = button;
    }

    @Override
    public void execute() {
        JFrame f = new JFrame();
        String hp = JOptionPane.showInputDialog(f,"HP: ");
        if (hp == null || hp.isEmpty()){
            hp = "10";
        }

        b.setText(hp);
        player.setHealthPoints(Integer.parseInt(hp));
    }
}
