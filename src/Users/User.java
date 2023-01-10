package Users;

import Main.ApplicationInstance;
import Patients.MedicalRecord;
import Patients.Patient;

import java.util.Scanner;

public class User {

    String name, lastName;

    public User (String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }


    public void dischargePatient(){
        Patient patient = searchPatient();
        MedicalRecord medicalRecord = ApplicationInstance.getPatientsMedicalRecord(patient);
        ApplicationInstance.getDepartmentByID(patient.getDepartmentID()).getRoomByID(patient.getRoomID()).getBedByPatient(patient).freeBed();
    }
    public Patient searchPatient(){
        Scanner scanner = new Scanner(System.in);
        Patient patient = null;
        int id;
        boolean search = true;
        while (true){
            System.out.print("Podaj id: ");
            id = Integer.parseInt(scanner.nextLine());
            patient = ApplicationInstance.getPatientById(id);
            if(patient!=null)
                return patient;

            String choice;
            System.out.println("Nie znaleziono pacjenta");
            System.out.println("Czy jeszcze raz szukac? [Y/N]");
            choice = scanner.nextLine();
            search = choice.equals("Y") || choice.equals("y");
            if (!search)
                return null;
        }
    }


    public MedicalRecord searchMedicalRecord(){
        Patient patient = searchPatient();
        if(patient==null)
            return null;
        return ApplicationInstance.getPatientsMedicalRecord(patient);
    }
}
