package io.muzoo.ssc.zork.map;

import io.muzoo.ssc.zork.Room;
import io.muzoo.ssc.zork.item.Crossbow;
import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.item.Painkiller;
import io.muzoo.ssc.zork.item.Vest;

import java.util.ArrayList;
import java.util.List;

public class SchoolMyMap extends MyMap {

    private Vest vest = new Vest();
    private Crossbow crossbow = new Crossbow();
    private Painkiller painkiller = new Painkiller();

    @Override
    public String getMyMapName() {
        return "school";
    }

    @Override
    protected void createRooms() {
        List<Item> gymItem = new ArrayList<>();
        gymItem.add(vest);
        List<Item> labItem = new ArrayList<>();
        labItem.add(crossbow);
        List<Item> canteenItem = new ArrayList<>();
        canteenItem.add(painkiller);
        List<Item> classroomItem = new ArrayList<>();
        classroomItem.add(vest);
        classroomItem.add(crossbow);
        List<Item> auditoriumItem = new ArrayList<>();
        auditoriumItem.add(vest);
        auditoriumItem.add(painkiller);

        Room gym = new Room("Gym", gymItem);
        Room lab = new Room("Lab", labItem);
        Room canteen = new Room("Canteen", canteenItem);
        Room classroom = new Room("Classroom", classroomItem);
        Room auditorium = new Room("Auditorium", auditoriumItem);

        gym.setExits(null, classroom, null, null);
        lab.setExits(null, null, classroom, null);
        canteen.setExits(classroom, null, null, null);
        classroom.setExits(auditorium, lab, gym, canteen);
        auditorium.setExits(null, null, null, classroom);

        currentRoom = classroom;
    }
}
