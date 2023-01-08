package examples;

import java.util.ArrayList;

public class Department {
    private static int counter = 1;
    private final int id;
    private final ArrayList<Patient> patients = new ArrayList<>();
    private final ArrayList<Room> rooms = new ArrayList<>();

    public Department(){
        this.id = counter;
        counter++;
        for (int i=0;i<10;i++){
            addRoom(new Room());
        }
    }

    public int getId() {
        return id;
    }

    public void addPatient(Patient patient){

        for (Room room: rooms){
            if(room.addPatient(patient)){
                patient.roomID = room.getId();
                return;
            }

        }
        System.out.println("Brak miejsca w departamencie");
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public Room getRoomByID(int id){
        for (Room room: rooms){
            if(room.getId() == id)
                return room;
        }
        return null;
    }
}
