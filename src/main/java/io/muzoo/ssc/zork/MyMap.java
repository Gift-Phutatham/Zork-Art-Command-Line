package io.muzoo.ssc.zork;

public class MyMap {

    private Room[] rooms;
    private Room currentRoom;

    public MyMap() {
        createRooms();
    }

    private void createRooms() {
        Room gym = new Room("Gym");
        Room lab = new Room("Lab");
        Room canteen = new Room("Canteen");
        Room classroom = new Room("Classroom");
        Room auditorium = new Room("Auditorium");

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
