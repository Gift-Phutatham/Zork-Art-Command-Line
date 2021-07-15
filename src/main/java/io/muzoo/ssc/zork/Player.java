package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public int HP;
    public int maxHP;
    private int bonusHP;
    public int fistPower;
    public List<Item> items = new ArrayList<>();

    public Player() {
        this.HP = 100;
        this.maxHP = 100;
        this.bonusHP = 20;
        this.fistPower = 3;
    }

    public void take(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public Item getItem(String item) {
        for (Item eachItem : items) {
            if (eachItem.getItemName().equals(item)) {
                return eachItem;
            }
        }
        return null;
    }

    public void drop(String item) {
        Item itemItem = getItem(item);
        if (itemItem == null) {
            System.out.println("No " + item + " found in player");
        } else {
            items.remove(itemItem);
        }
    }

    public int attackWith(String item) {
        Item itemItem = getItem(item);
        if (itemItem != null) {
            return itemItem.getAttackPower();
        }
        return fistPower;
    }

    private int getDefensePower() {
        for (Item eachItem : items) {
            int defensePower = eachItem.getDefensePower();
            if (defensePower > 0) {
                return defensePower;
            }
        }
        return 0;
    }

    public void receiveDamage(int attackPower) {
        int damage = attackPower - getDefensePower();
        this.HP -= damage;
        System.out.println("Player receives " + damage + " of damage");
        System.out.println("Current HP of player: " + this.HP);
    }

    private int getBoostPower() {
        for (Item eachItem : items) {
            int boostPower = eachItem.getBoostPower();
            if (boostPower > 0) {
                return boostPower;
            }
        }
        return 0;
    }

    public void go() {
        int boostPower = getBoostPower();
        int moreHP = boostPower + this.bonusHP;
        this.HP += moreHP;
        if (this.HP > this.maxHP) {
            this.HP = this.maxHP;
        }
        System.out.println("Player receives " + moreHP + " more of HP");
        System.out.println("Current HP: " + this.HP);
    }
}
