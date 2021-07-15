package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int HP;
    private int maxHP;
    private int fistPower;
    private List<Item> items = new ArrayList<>();

    public Player() {
        this.HP = 100;
        this.maxHP = 100;
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

    public void boostHP(int boostPower) {
        this.HP += boostPower;
        System.out.println("Player receives " + boostPower + " more of HP");
        System.out.println("Current HP: " + this.HP);
    }

    public void printInfo() {
        System.out.println("PLAYER STAT");
        System.out.println("  Current HP: " + this.HP);
        System.out.println("  Maximum HP: " + this.maxHP);
        System.out.println("  Fist power: " + this.fistPower);
        System.out.println("  Item in Player");
        if (items.isEmpty()) {
            System.out.println("    None");
        } else {
            for (Item eachItem : items) {
                System.out.println("    " + eachItem.getItemName() + "'s attack power: " + eachItem.getAttackPower());
                System.out.println("    " + eachItem.getItemName() + "'s defense power: " + eachItem.getDefensePower());
                System.out.println("    " + eachItem.getItemName() + "'s boost power: " + eachItem.getBoostPower());
            }
        }
    }
}
