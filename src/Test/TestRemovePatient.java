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
        int count1 = room.CountFreeBeds();
        room.removePatient(patient);
        int count2 = room.CountFreeBeds();
        assertEquals("Usunieto pacjenta z pokoju",count1+1,count2);
    }
    @org.junit.Test
    public void testRemovePatientFromDepartment(){
        Department department = new Department(4);
        Patient patient = new Patient("test","test2",1,"testpesel");
        department.addPatient(patient);
        int count1 = department.getPatients().size();
        department.removePatient(patient);
        int count2 = department.getPatients().size();
        assertEquals("Usunieto pacjenta z pokoju", count1-1,count2);
    }
}
