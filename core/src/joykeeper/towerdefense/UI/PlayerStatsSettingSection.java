package joykeeper.towerdefense.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import joykeeper.towerdefense.Commands.ChangeHPCommand;
import joykeeper.towerdefense.Commands.ChangeMoneyCommand;
import joykeeper.towerdefense.Player;
import joykeeper.towerdefense.Vector;

public class PlayerStatsSettingSection {
    MyLabel playerStatsLabel;
    Button changeHPButton;
    Button changeMoneyButton;
    Vector position;
    public PlayerStatsSettingSection(Vector position, Player player){
        this.position = position;
        this.playerStatsLabel = new MyLabel("Player stats:", position);

        new MyLabel("HP: ", new Vector(this.position.x-60, this.position.y-35));
        this.changeHPButton = new Button(Integer.toString(player.getHealthPoints()), new Vector(this.position.x-25, this.position.y-35), new Vector(30, 30), new Color(0.9f, 0.9f, 0.8f, 0.5f));

        MyLabel money = new MyLabel("Money: ", new Vector(this.position.x+25, this.position.y-35));
        this.changeMoneyButton = new Button(Integer.toString(player.getMoney()), new Vector(this.position.x+60, this.position.y-35), new Vector(30, 30), new Color(0.9f, 0.9f, 0.8f, 0.5f));

        this.changeMoneyButton.setCommand(new ChangeMoneyCommand(player, changeMoneyButton));
        this.changeHPButton.setCommand(new ChangeHPCommand(player, changeHPButton));
    }

    public void updatePlayerStats(Player player){
        this.changeHPButton.setText(Integer.toString(player.getHealthPoints()));
        this.changeMoneyButton.setText(Integer.toString(player.getMoney()));
    }
}
