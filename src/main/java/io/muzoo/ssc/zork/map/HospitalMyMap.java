package io.muzoo.ssc.zork.map;

import io.muzoo.ssc.zork.Room;
import io.muzoo.ssc.zork.item.Crossbow;
import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.item.Painkiller;
import io.muzoo.ssc.zork.item.Vest;

import java.util.ArrayList;
import java.util.List;

public class HospitalMyMap extends MyMap {

    private Vest vest = new Vest();
    private Crossbow crossbow = new Crossbow();
    private Painkiller painkiller = new Painkiller();

    @Override
    public String getMyMapName() {
        return "hospital";
    }

    @Override
    protected void createRooms() {
        List<Item> icuItem = new ArrayList<>();
        icuItem.add(vest);
        icuItem.add(crossbow);
        icuItem.add(painkiller);
        List<Item> emergencyRoomItem = new ArrayList<>();
        emergencyRoomItem.add(vest);
        List<Item> operatingRoomItem = new ArrayList<>();
        operatingRoomItem.add(crossbow);

        Room ICU = new Room("ICU", icuItem);
        Room emergencyRoom = new Room("Emergency Room", emergencyRoomItem);
        Room operatingRoom = new Room("Operating Room", operatingRoomItem);

        ICU.setExits(null, emergencyRoom, null, null);
        emergencyRoom.setExits(null, operatingRoom, ICU, null);
        operatingRoom.setExits(null, null, emergencyRoom, null);

        currentRoom = ICU;
    }
}
