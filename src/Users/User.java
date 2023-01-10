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
        while (search){
            printMenu();
            System.out.println("Wybierz opcję");
            choice2 = Integer.parseInt(scanner.nextLine());
            switch(choice2){

                case 1: // by id
                    System.out.print("Podaj id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    patient = ApplicationInstance.getPatientById(id);
                    break;

                case 2: // by pesel
                    System.out.print("Podaj pesel delikwenta:  ");
                    pesel = scanner.nextLine();
                    patient = ApplicationInstance.getPatientByPesel(pesel);
                    break;

                case 3: // by full name
                    System.out.print("Podaj imie delikwenta:  ");
                    imie = scanner.nextLine();
                    System.out.print("Podaj nazwisko delikwenta:  ");
                    nazwisko = scanner.nextLine();
                    patient = ApplicationInstance.getPatientByFullname(imie, nazwisko);
                    break;

                default:
                    System.out.println("Wybierz opcje ponownie");

            }

            if(patient!=null)
                return patient;
            String choice;
            System.out.println("Nie znaleziono pacjenta");
            System.out.println("Czy jeszcze raz szukac? [Y/N]");
            choice = scanner.nextLine();
            search = choice.equalsIgnoreCase("y");

        }
        return patient;
    }
    public MedicalRecord searchMedicalRecord(){
        Patient patient = searchPatient();
        if(patient==null)
            return null;
        MedicalRecord medicalRecord = ApplicationInstance.getPatientsMedicalRecord(patient);
        medicalRecord.print();
        return medicalRecord;
    }
}
