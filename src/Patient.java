

public class Patient {

    private static int counter = 1;
    String name, surname;
    int id, departmentID, roomID;



    public Patient (String name, String surname, int departmentID){
        this.name = name;
        this.surname = surname;
        this.id = counter;
        this.departmentID=departmentID;
        counter++;
        Main.addPatient(this);
        Main.addMedicalRecord(this);
        Main.getDepartmentByID(departmentID).addPatient(this);
        Main.getDepartmentByID(departmentID).getRoomByID(roomID).addPatient(this);

    }

    public int getId() {
        return id;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public int getRoomID() {
        return roomID;
    }
}
