package io.muzoo.ssc.zork;

import java.util.HashMap;
import java.util.Map;

public class Room {

    private String roomName;
    private Monster monster;
    public Map<String, Room> map;

    public Room(String roomName) {
        map = new HashMap<>();
        monster = new Monster();
        this.roomName = roomName;
    }

    public void setExits(Room north, Room east, Room west, Room south) {
        String[] directions = new String[] {"north", "east", "west", "south"};
        Room[] rooms = new Room[] {north, east, west, south};
        for (int i = 0; i < directions.length; i++) {
            map.put(directions[i], rooms[i]);
        }
    }

    public String getRoomName() {
        return roomName;
    }
}
