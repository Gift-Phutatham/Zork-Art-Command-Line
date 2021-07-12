package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.item.Crossbow;
import io.muzoo.ssc.zork.item.Item;
import io.muzoo.ssc.zork.item.Painkiller;
import io.muzoo.ssc.zork.item.Vest;

public class MyMap {

    private Room[] rooms;
    private Room currentRoom;
    private Vest vest;
    private Crossbow crossbow;
    private Painkiller painkiller;

    public MyMap() {
        createRooms();
    }

    private void createRooms() {
        Item[] gymItem = {vest};
        Item[] labItem = {crossbow};
        Item[] canteenItem = {painkiller};
        Item[] classroomItem = {vest, crossbow};
        Item[] auditoriumItem = {vest, painkiller};

        Room gym = new Room("Gym", gymItem);
        Room lab = new Room("Lab", labItem);
        Room canteen = new Room("Canteen", canteenItem);
        Room classroom = new Room("Classroom", classroomItem);
        Room auditorium = new Room("Auditorium", auditoriumItem);

        rooms = new Room[] {gym, lab, canteen, classroom, auditorium};

        gym.setExits(null, classroom, null, null);
        lab.setExits(null, null, classroom, null);
        canteen.setExits(classroom, null, null, null);
        classroom.setExits(auditorium, lab, gym, canteen);
        auditorium.setExits(null, null, null, classroom);

        currentRoom = classroom;
    }

    public void go(String direction) {
        if (direction.equals("")) {
            System.out.println("Go where?");
            return;
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
    }
}
