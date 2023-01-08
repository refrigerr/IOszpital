package examples;

import java.util.Scanner;

public class User {

    public User (){

    }

    public void editPatientsMedicalRecord(){
        Patient patient = searchPatient();
        MedicalRecord medicalRecord = A.getPatientsMedicalRecord(patient);
        addRecordToMedicalRecord(medicalRecord);

    }
    public void dischargePatient(){
        Patient patient = searchPatient();
        MedicalRecord medicalRecord = A.getPatientsMedicalRecord(patient);
        addRecordToMedicalRecord(medicalRecord);
        A.getDepartmentByID(patient.getDepartmentID()).getRoomByID(patient.getRoomID()).getBedByPatient(patient).freeBed();
    }
    public Patient searchPatient(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj id: ");
        return A.getPatientById(scanner.nextInt());
    }

    public void addRecordToMedicalRecord(MedicalRecord medicalRecord){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj wpis: ");
        medicalRecord.addRecord(scanner.nextLine());

    }

}
