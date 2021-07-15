package io.muzoo.ssc.zork;

public class Monster {

    private int HP;
    private int attackPower;
    private boolean isAlive;

    public Monster() {
        HP = 100;
        attackPower = 30;
        isAlive = true;
    }

    public int getHP() {
        return HP;
    }

    public void setDead() {
        isAlive = false;
    }

    public void receiveDamage(int damage) {
        if (isAlive) {
            HP -= damage;
            System.out.println("Monster receives " + damage + " of damage");
        }
        if (HP <= 0) {
            setDead();
            System.out.println("Monster is dead");
        } else {
            System.out.println("Current HP of monster: " + HP);
        }
    }

    public int sendDamage() {
        return attackPower;
    }
}
