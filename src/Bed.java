package examples;

public class Bed {

    private Patient patient = null;


    public Bed(){

    }

    public Patient getPatient(){
        return patient;
    }

    public void freeBed(){
        this.patient = null;
    }
    public void assignPatient(Patient patient){
        this.patient = patient;
    }

}
