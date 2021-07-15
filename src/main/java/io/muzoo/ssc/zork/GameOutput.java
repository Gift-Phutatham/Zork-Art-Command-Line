package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Item;

import java.util.List;

import io.muzoo.ssc.zork.map.SchoolMap;
import org.apache.commons.lang3.StringUtils;

public class GameOutput {

    public void println(String message) {
        System.out.println(message);
    }

    private void printItem(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("    None");
        } else {
            for (Item eachItem : items) {
                System.out.printf("    %s:\n", StringUtils.capitalize(eachItem.getItemName()));
                System.out.println("      Attack power: " + eachItem.getAttackPower());
                System.out.println("      Defense power: " + eachItem.getDefensePower());
                System.out.println("      Boost power: " + eachItem.getBoostPower());
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

    public void printRoomInfo(SchoolMap schoolMap) {
        System.out.println("ROOM INFORMATION");
        System.out.println("  Current room: " + schoolMap.currentRoom.getRoomName());
        for (String direction : schoolMap.currentRoom.map.keySet()) {
            Room room = schoolMap.currentRoom.map.get(direction);
            if (room != null) {
                System.out.printf("  %s's %s: %s\n", schoolMap.currentRoom.getRoomName(), direction, room.getRoomName());
            }
        }
        Monster monster = schoolMap.getMonster();
        System.out.println("  Monster's HP: " + monster.getHP());
        System.out.println("  Monster's default attack power: " + monster.sendDamage());
        System.out.println("  Item in room:");
        printItem(schoolMap.currentRoom.items);
    }
}
