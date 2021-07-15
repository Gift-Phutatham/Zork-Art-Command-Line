package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Crossbow;
import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.item.Painkiller;
import io.muzoo.ssc.zork.item.Vest;

import java.util.ArrayList;
import java.util.List;

public class MyMap {

    public Room currentRoom;
    private Vest vest = new Vest();
    private Crossbow crossbow = new Crossbow();
    private Painkiller painkiller = new Painkiller();

    public MyMap() {
        createRooms();
    }

    private void createRooms() {
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
