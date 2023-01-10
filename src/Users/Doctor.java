package Users;

import Main.ApplicationInstance;
import Patients.MedicalRecord;
import Patients.Patient;
import Patients.Record;

import java.util.Scanner;

public class Doctor extends User{

    public Doctor (String name, String lastName){
        super(name,lastName);
    }

    public void editPatientsMedicalRecord(){
        MedicalRecord medicalRecord = searchMedicalRecord();
        if(medicalRecord==null)
            return;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to insert record? [Y/N]");
        String choice = scanner.nextLine();
        while (!choice.equals("N")&&!choice.equals("n")){
            addRecordToMedicalRecord(medicalRecord);
        }
    }
    public void addRecordToMedicalRecord(MedicalRecord medicalRecord){
        boolean insertNextRecord = true;
        String choice;
        while (insertNextRecord){
            Scanner scanner = new Scanner(System.in);
            String title, description;
            System.out.print("Podaj tytul: ");
            title = scanner.nextLine();
            System.out.print("Podaj Wpis: ");
            description = scanner.nextLine();
            medicalRecord.addRecord(new Record(title,name+" "+lastName, description));
            System.out.println("Czy chcesz dodac kolejny wpis? [Y/N]");
            choice = scanner.nextLine();
            insertNextRecord = choice.equals("Y") || choice.equals("y");
        }
    }
}
