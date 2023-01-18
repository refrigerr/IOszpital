package Test;

import Hospital.Bed;
import Hospital.Department;
import Hospital.Room;
import Patients.Patient;

import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void showDepartmentInfo(){
        assert(true);

    }
    @org.junit.Test
    public void testAddPatientToRoom(){
        Room room = new Room(6);
        Patient patient = new Patient("test","test2",1,"testpesel");
        assertTrue("Pacent istnieje w pokoju", room.addPatient(patient));

    }
    @org.junit.Test
    public void testNoBedsAvailableInRoom(){
        Room room = new Room(6);
        for (Bed bed: room.getBeds()){
            bed.assignPatient(new Patient("test","test2",1,"testpesel"));
        }
        Patient patient = new Patient("test","test2",1,"testpesel");
        assertFalse("Brak miejsca w pokoju", room.addPatient(patient));
    }
    @org.junit.Test
    public void testAddPatientToBed(){
        Bed bed = new Bed();
        bed.assignPatient(new Patient("test","test2",1,"testpesel"));
        assertNotNull("Pacjent lezy na lozku", bed.getPatient());
    }
    @org.junit.Test
    public void testRemovePatientFromBed(){
        Bed bed = new Bed();
        bed.assignPatient(new Patient("test","test2",1,"testpesel"));
        bed.freeBed();
        assertNull("Pacjent nie lezy na lozku", bed.getPatient());
    }
    @org.junit.Test
    public void testAddPatientToDepartment(){
        Department department = new Department(1);
        Patient patient = new Patient("test","test2",1,"testpesel");
        department.addPatient(patient);
        assertTrue("Pacjent istnieje w departamencie", department.patientExists(patient));
    }

}
