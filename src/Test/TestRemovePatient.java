package Test;

import Hospital.Bed;
import Hospital.Department;
import Hospital.Room;
import Patients.Patient;

import static org.junit.Assert.*;
public class TestRemovePatient {

    @org.junit.Test
    public void testRemovePatientFromBed(){
        Bed bed = new Bed();
        bed.assignPatient(new Patient("test","test2",1,"testpesel"));
        bed.freeBed();
        assertNull("Usunieto pacjetna z lozka", bed.getPatient());
    }
    @org.junit.Test
    public void testRemovePatientFromRoom(){
        Room room = new Room(4);
        Patient patient = new Patient("test","test2",1,"testpesel");
        room.addPatient(patient);
        assertTrue("Usunieto pacjenta z pokoju",room.removePatient(patient));
    }
    @org.junit.Test
    public void testRemovePatientFromDepartment(){
        Department department = new Department(4);
        Patient patient = new Patient("test","test2",1,"testpesel");
        department.addPatient(patient);
        assertTrue("Usunieto pacjenta z pokoju", department.removePatient(patient));
    }
}
