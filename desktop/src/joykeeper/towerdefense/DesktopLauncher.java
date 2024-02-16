package joykeeper.towerdefense;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import joykeeper.towerdefense.TowerDefenseGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("TowerDefense");
		config.setWindowedMode(800, 480);
		new Lwjgl3Application(new TowerDefenseGame(), config);
	}
}
