package joykeeper.towerdefense.Commands;

import joykeeper.towerdefense.Player;
import joykeeper.towerdefense.UI.Button;

import javax.swing.*;

public class ChangeMoneyCommand implements Command{
    Button b;
    Player player;

    public ChangeMoneyCommand(Player player, Button button){
        this.player = player;
        this.b = button;
    }

    @Override
    public void execute() {
        JFrame f = new JFrame();
        String money=JOptionPane.showInputDialog(f,"Money: ");
        if (money == null ||money.isEmpty()){
            money = "100";
        }


        b.setText(money);
        player.setMoney(Integer.parseInt(money));
    }
}
