package examples;

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
        A.addPatient(this);
        A.addMedicalRecord(this);
        A.getDepartmentByID(departmentID).addPatient(this);
        A.getDepartmentByID(departmentID).getRoomByID(roomID).addPatient(this);

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
