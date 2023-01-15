package Hospital;

import Hospital.Bed;
import Patients.Patient;

import java.util.ArrayList;

public class Room {

    private static int counter = 1;
    private int id;

    private final ArrayList<Bed> beds = new ArrayList<>();

    public Room (){
        this.id = counter;
        counter++;
        for (int i=0;i<6;i++){
            addBed(new Bed());
        }
    }

    public void addBed(Bed bed){
        beds.add(bed);
    }

    public int getId() {
        return id;
    }

    public Bed getBedByPatient(Patient patient){
        for (Bed bed: beds){
            if(bed.getPatient().equals(patient))
                return bed;
        }
        return null;
    }

    public boolean addPatient(Patient patient){
        for (Bed bed: beds){
            if(bed.getPatient()==null){
                bed.assignPatient(patient);
                return true;
            }

        }
        return false;
    }

    public boolean removePatient(Patient patient){
        for(Bed bed: beds) {
            if (bed.getPatient() == patient) {
                bed.freeBed();
                return true;
            }
        }
        return false;
    }
    public ArrayList<Bed> getBeds(){
        return beds;
    }
}
