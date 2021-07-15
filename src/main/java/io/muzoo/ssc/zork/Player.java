package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Item> items = new ArrayList<>();

    public Player() {}

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

    public void printItemInfo() {
        System.out.println("Item in Player");
        for (Item eachItem : items) {
            System.out.println("  " + eachItem.getItemName());
        }
    }
}
