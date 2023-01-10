package Patients;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    ArrayList<Record> records = new ArrayList<>();

    public MedicalRecord(){
        records.add(new Record("Zarejestrowanie w szpitalu","System","Pacjent poraz pierwszy został przyjęty do szpitala"));
    }

    public void addRecord(Record record){
        records.add(record);
    }
    public void show(){
        for (Record record: records){
            record.printRecord();
        }
    }
}
