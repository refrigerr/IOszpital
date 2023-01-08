package examples;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    ArrayList<String> records = new ArrayList<>();

    public MedicalRecord(){
        records.add("Wpis do szpitala");
    }

    public void addRecord(String record){
        records.add(record);
    }
    public void show(){
        for (String s: records){
            System.out.println(s);
        }
    }
}
