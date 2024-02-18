![image](https://github.com/Joykeeper/TowerDefense/assets/142427136/9cd5e6db-aae0-4c59-8926-bdb8ed694fbf)



It is a tower defense game. Your goal is to not let enemies reach their endpoint.

To start game: launch file 'desktop/src/joykeeper/towerdefense/DesktopLauncher.java'

Menu (click “Escape” from whatever scene to get to Menu):
-	Play default map: here you can play the basic map. 

Towers. You can put towers on yellow tiles (click on tile -> select tower type from right panel). Towers worth money. Money is shown in top-right corner.
  - o	  - Green tower(“basic”): average damage, shooting rate and radius. 
- o	  - Blue tower(“fast”): small damage and radius, big shooting rate.
- o	  - Orange tower(“sniper”): big damage and radius, small shooting rate.

Waves. Each wave there are three enemies, each of them is a different type: 
- o	  - Pink(“basic”): average health and speed.
- o	  - Brown(“tank”): a lot of health and slow speed;
- o	  - Blue(“fast”): low health and fast speed.

For eliminating enemies, you will be rewarded with some money. Current wave is shown in top right corner. With each wave enemies will have more health and give more money. Allowing enemies to reach the endpoint will cause player’s health to go down.
-	Create map: here you can create maps for the game and save them (“Save” button) to “levels”(in "assets" directory) folder.

Also, you can load levels to edit them (“Load” button).
To draw tiles, click on desired tile and then click on the field where you want to put the tile.
There are five types of tiles:
- o	Start tile(blue): here enemies will spawn. Can be only one. Has direction.
- o	Stop tile(black): endpoint of enemies. Can be only one.
- o	Road tile(green): road on which enemies will go. Has direction.
- o	Tower tile(yellow): tiles where towers can be put.
- o	Void tile(grey): tile without functionality.

You won’t be able to save map until it has only one start and one stop tiles and also, they should be connected by road tiles. 

Pay attention to the corners:
![image](https://github.com/Joykeeper/TowerDefense/assets/142427136/af954636-2150-4dfb-933b-ea2833b2645b) - working corner.
![image](https://github.com/Joykeeper/TowerDefense/assets/142427136/30e36a9c-e61b-4805-88e3-71d9c209ac2f) - not working corner.

Start and road tiles have direction - it is the tile they will lead to.

Player stats are the stats with which the map will be played. To change them: click on the number and write desired amount for HP and money.

Example of saveable maps:

![image](https://github.com/Joykeeper/TowerDefense/assets/142427136/2f5ec309-918e-472a-9826-6720f8b2758a)

![image](https://github.com/Joykeeper/TowerDefense/assets/142427136/18ee5e85-bba2-4aa4-aaa6-cb13c6429943)
 
-	Choose map: here you select to play and delete your saved levels which are located in the “levels” folder. To play the level, click on the image of the level. To delete the level click on red “Delete” button.
![image](https://github.com/Joykeeper/TowerDefense/assets/142427136/c4d63d4b-a64b-4cdc-b94a-a05d959e35ab)

