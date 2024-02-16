package joykeeper.towerdefense;

public class Player {
    private int money;
    private int healthPoints;
    public Player(int money, int healthPoints){

        this.money = money;
        this.healthPoints = healthPoints;
    }
    public int getMoney(){
        return this.money;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void receiveMoney(int amount){
        this.money += amount;
    }
    public void takeDamage(int damage){
        this.healthPoints -= damage;
    }

    public void spendMoney(int amount){
        this.money -= amount;
    }
}
