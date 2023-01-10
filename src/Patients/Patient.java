package Patients;

import Main.ApplicationInstance;

public class Patient {

    private static int counter = 1;
    String name, surname;
    int id;
    int departmentID;
    public int roomID;



    public Patient (String name, String surname, int departmentID){
        this.name = name;
        this.surname = surname;
        this.id = counter;
        this.departmentID=departmentID;
        counter++;
        ApplicationInstance.addPatient(this);
        ApplicationInstance.addMedicalRecord(this);
        ApplicationInstance.getDepartmentByID(departmentID).addPatient(this);
        ApplicationInstance.getDepartmentByID(departmentID).getRoomByID(roomID).addPatient(this);

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

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
}
