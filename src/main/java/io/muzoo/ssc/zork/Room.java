package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private String roomName;
    private Monster monster;
    private List<Item> items;
    public Map<String, Room> map;

    public Room(String roomName, List<Item> items) {
        map = new HashMap<>();
        monster = new Monster();
        this.items = items;
        this.roomName = roomName;
    }

    public void setExits(Room north, Room east, Room west, Room south) {
        String[] directions = new String[]{"north", "east", "west", "south"};
        Room[] rooms = new Room[]{north, east, west, south};
        for (int i = 0; i < directions.length; i++) {
            map.put(directions[i], rooms[i]);
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public Item getItem(String item) {
        for (Item eachItem : items) {
            if (eachItem.getItemName().equals(item)) {
                return eachItem;
            }
        }
        return null;
    }

    public Item take(String item) {
        Item itemItem = getItem(item);
        if (itemItem == null) {
            System.out.println("No " + item + " found in room");
        } else {
            items.remove(itemItem);
        }
        return itemItem;
    }

    public void printItemInfo() {
        System.out.println("Item in Room");
        for (Item eachItem : items) {
            System.out.println("  " + eachItem.getItemName());
        }
    }
}
