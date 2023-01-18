package Test;

import Hospital.Department;
import Hospital.Room;
import Main.ApplicationInstance;
import org.junit.Test;

import static Main.ApplicationInstance.departments;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestGetFreeBed {

    @Test
    public void Department(){
        // coming soon...
    }

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

/*    @Test
    public void testSearchFreeBed(){
        Department department = new Department(12);
        for(Room room: department.showRooms()){
            for(Bed bed: room.getBeds()){
                    assertNull("Znaleziono wolne lozko", bed.getPatient());
            }
        }
    }*/

    @Test
    public void testSearchFreeBeds(){
        Department department = new Department(12);
        assertTrue(department.CheckBedAvabality());
    }

}
