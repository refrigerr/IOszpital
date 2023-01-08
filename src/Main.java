import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static HashMap<Patient, MedicalRecord> medicalRecords = new HashMap<>();

    public static ArrayList<Department> departments = new ArrayList<>();

    public static void main(String[] args) {
        User user = new User();
        addDepartment(new Department());
        new Patient("imie","nazwisko",1);
        user.dischargePatient();

    }

    public static Patient getPatientById(int id){
        for (Patient p: patients){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
    public static MedicalRecord getPatientsMedicalRecord(Patient patient){
        return medicalRecords.get(patient);
    }

    public static void addMedicalRecord(Patient patient){
        medicalRecords.put(patient, new MedicalRecord());
    }

    public static void addPatient(Patient patient){
        patients.add(patient);
    }

    public static Department getDepartmentByID(int id){
        for (Department department: departments)
            if(department.getId()==id)
                return department;
        return null;
    }
    public static void addDepartment(Department department){
        departments.add(department);
    }
}