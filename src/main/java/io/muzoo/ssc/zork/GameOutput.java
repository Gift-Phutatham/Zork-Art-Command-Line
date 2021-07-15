package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.List;

public class GameOutput {

    public void println(String message) {
        System.out.println(message);
    }

    private void printItem(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("    None");
        } else {
            for (Item eachItem : items) {
                System.out.printf("    %s's attack power: %d\n", eachItem.getItemName(), eachItem.getAttackPower());
                System.out.printf("    %s's defense power: %d\n", eachItem.getItemName(), eachItem.getDefensePower());
                System.out.printf("    %s's boost power: %d\n", eachItem.getItemName(), eachItem.getBoostPower());
            }
        }
    }

    public void printPlayerInfo(Player player) {
        System.out.println("PLAYER STAT");
        System.out.println("  Current HP: " + player.HP);
        System.out.println("  Maximum HP: " + player.maxHP);
        System.out.println("  Default attack power: " + player.fistPower);
        System.out.println("  Item in player:");
        printItem(player.items);
    }

    public void printRoomInfo(MyMap myMap) {
        System.out.println("ROOM INFORMATION");
        System.out.println("  Current room: " + myMap.currentRoom.getRoomName());
        for (String direction : myMap.currentRoom.map.keySet()) {
            Room room = myMap.currentRoom.map.get(direction);
            if (room != null) {
                System.out.printf("  %s's %s: %s\n", myMap.currentRoom.getRoomName(), direction, room.getRoomName());
            }
        }
        Monster monster = myMap.getMonster();
        System.out.println("  Monster's HP: " + monster.getHP());
        System.out.println("  Monster's default attack power: " + monster.sendDamage());
        System.out.println("  Item in room:");
        printItem(myMap.currentRoom.items);
    }
}
