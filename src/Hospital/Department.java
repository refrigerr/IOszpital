package Hospital;

import Hospital.Room;
import Patients.Patient;

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
                patients.add(patient);
                return;
            }

        }
        System.out.println("Brak miejsca w departamencie");
    }

    public void removePatient(Patient patient){
        for (Room room: rooms){
            if(room.removePatient(patient)){
                patient.roomID = -1;
                patients.remove(patient);
            }
        }
        System.out.println("ODMOWA - brak pacjenta na oddziale");
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void removeRoom(Room room){
        if(getRoomByID(room.getId()) != null){
            rooms.remove(room);
        }
        else{
            System.out.println("ODMOWA - wybrany pokoj nie istnieje");
        }
    }

    public ArrayList<Room> showRooms(){
        return rooms;
    }

    public Room getRoomByID(int id){
        for (Room room: rooms){
            if(room.getId() == id)
                return room;
        }
        return null;
    }
}
