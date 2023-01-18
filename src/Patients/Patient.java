package Patients;

import Main.ApplicationInstance;

public class Patient {

    private static int counter = 1;
    String name, surname, pesel;
    int id;
    int departmentID;
    public int roomID;



    public Patient (String name, String surname, int departmentID, String pesel){
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.id = counter;
        this.departmentID=departmentID;
        counter++;
    }

    public int getId() {
        return id;
    }

    public String getPesel() {
        return this.pesel;
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
