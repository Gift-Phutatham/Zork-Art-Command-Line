package io.muzoo.ssc.zork.map;

import io.muzoo.ssc.zork.Monster;
import io.muzoo.ssc.zork.Room;
import io.muzoo.ssc.zork.item.Item;

public abstract class MyMap {

    public Room currentRoom;

    public void initialize() {
        createRooms();
    }

    public abstract String getMyMapName();

    protected abstract void createRooms();

    public Room go(String direction) {
        if (direction.equals("")) {
            System.out.println("Go where?");
            return null;
        }
        Room nextRoom = null;
        for (String i : currentRoom.map.keySet()) {
            if (direction.equals(i)) {
                nextRoom = currentRoom.map.get(i);
            }
        }
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getRoomName());
        }
        return nextRoom;
    }

    public Item take(String item) {
        return currentRoom.take(item);
    }

    public Monster getMonster() {
        return currentRoom.getMonster();
    }
}
