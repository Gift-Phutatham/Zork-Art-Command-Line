package io.muzoo.ssc.zork;

public class Monster {

    private int HP;
    private int attackPower;

    public Monster() {
        HP = 100;
        attackPower = 10;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int damage) {
        HP -= damage;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
