package Test;

import static Main.ApplicationInstance.departments;
import static Main.ApplicationInstance.patients;
import static org.junit.Assert.*;

import Hospital.Bed;
import Hospital.Department;
import Hospital.Room;
import Main.ApplicationInstance;
import Patients.Patient;
import org.junit.Test;

public class TestGetFreeBed {

    @Test
    public void testSearchDepartment(){
        Department test_department = new Department(10);
        departments.add(test_department);
        assertTrue("Znaleziono oddzial", ApplicationInstance.departmentExists(test_department));
    }

    @Test
    public void testGetRooms(){
        Department department = new Department(10);
        assertNotNull("Znaleziono pokoje", department.showRooms());
    }
    @Test
    public void testGetBeds(){
        Department department = new Department(10);
        for(Room room: department.showRooms()){
            assertNotNull("Znaleziono lozka w pokoju", room.getBeds());
        }
    }

    @Test
    public void testSearchFreeBed(){
        Department department = new Department(12);
        for(Room room: department.showRooms()){
            for(Bed bed: room.getBeds()){
                    assertNull("Znaleziono wolne lozko", bed.getPatient());
            }
        }
    }

}