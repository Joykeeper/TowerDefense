package joykeeper.towerdefense;

import joykeeper.towerdefense.additionalPanels.AdditionalPanel;

public class PanelHolder implements Updateable{
    AdditionalPanel holdingPanel;
    public PanelHolder(){
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addUpdatable(this);
    }
    public void setPanel(AdditionalPanel panel){
        clearHoldingPanel();

        this.holdingPanel = panel;
    }
    public void clearHoldingPanel(){
        TowerDefenseGame.instance.sceneManager.getCurrentScene().addObjectToRemove(this.holdingPanel);

        this.holdingPanel = null;
    }

    @Override
    public void update(float deltaTime) {
        if (this.holdingPanel != null && this.holdingPanel.isDestroyed()){
            clearHoldingPanel();
        }
    }
}
