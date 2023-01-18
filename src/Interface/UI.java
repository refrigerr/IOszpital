package Interface;

import Hospital.Bed;
import Hospital.Room;
import Main.ApplicationInstance;
import Patients.Patient;
import Users.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

import static Main.ApplicationInstance.departments;
import static Main.ApplicationInstance.patients;

public class UI {

    public static String GetUserResponse(String command){
        Scanner scanner = new Scanner(System.in);
        System.out.println(command);
        return scanner.nextLine();
    }

    public static boolean ChechInput(String input, int format){
        boolean is_ok = false;
        if(input == null){
            return false;
        }
        switch(format){
            case 1: // imie lub nazwisko
                try {
                    double d = Double.parseDouble(input);
                } catch (NumberFormatException nfe) {
                    is_ok = true;
                }
                break;

            case 2: // id czegos, numer opcji
                is_ok = true;
                try {
                    int d = Integer.parseInt(input);
                } catch (NumberFormatException nfe) {
                    is_ok = false;
                }
                break;

            case 3: // pesel
                is_ok = true;
                for(int i=0; i<input.length(); i++){
                    try {
                        int d = Integer.parseInt(String.valueOf(input.charAt(i)));
                    } catch (NumberFormatException nfe) {
                        is_ok = false;
                    }
                    if(!is_ok){
                        return false;
                    }
                }
                break;
        }
        return is_ok;
    }

    public static void GetErroInputMessage(boolean is_ok){
        if(!is_ok){
            System.out.println("Wpisano bledne dane");
        }
    }
    public static void StartMenu(){
        String response;
        int num_response;
        final String start = "============== SYSTEM ZARZADZANIA SZPITALEM ============== \n === STRONA GLOWNA ===";
        System.out.println(start);

        final String role_choice = " 1. Wybor uprawnien \n 2. Wyjdz";
        response = GetUserResponse(role_choice);
        if(Integer.parseInt(response)!= 1)
            return;
        int choice = RoleChoice();
        switch(choice){
            case 1: // lekarz
                DoctorsMenu();
                break;

            case 2: // pielegniarka
                NurseMenu();
                break;

            case 3: // Pracownik izby przyjec
                ReceptionistMenu();
                break;
        }

    }

    public static int RoleChoice(){
        String roles = "== WYBOR UPRAWNIEN == \n 1. Lekarz \n 2. Pielegniarka \n 3. Pracownik izby przyjec";
        return Integer.parseInt(GetUserResponse(roles));
    }

    public static void DoctorsMenu(){
        final String choice = "== MENU LEKARZA== \n 1. Wypisz pacjenta \n 2. Wypisz recepte \n 3. Wypisz skierowanie \n 4. Edytuj dokumentacje medyczna pacjenta";
        int response = Integer.parseInt(GetUserResponse(choice));
        switch(response){
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                ApplicationInstance.editPatientsMedicalRecord();
                break;
        }

    }

    public static void showDepartmentInfo(){
        int oddzial = Integer.parseInt(GetUserResponse("Wpisz numer oddzialu: \n"));
        ArrayList<Room> pokoje = new ArrayList<>();
        pokoje = departments.get(oddzial).showRooms();
        System.out.println("Pokoje: \n");
        for(Room room: pokoje){
            System.out.println("Pokoj numer: " + room.getId());
            System.out.println("Pacjenci: ");
            for(Bed bed: room.getBeds()){
                if(bed.getPatient()!=null){
                    System.out.println(bed.getPatient().getName() + " " + bed.getPatient().getSurname() + " " + bed.getPatient().getPesel());
                    System.out.println("");
                }
            }
        }
    }
    public static void putPatientInfo(){
        String imie = GetUserResponse("Podaj imie: \n");
        String nazwisko = GetUserResponse("Podaj nazwisko: \n");
        String pesel = GetUserResponse("Podaj pesel: \n");
        int oddzial = Integer.parseInt(GetUserResponse("Podaj id oddzialu: \n"));
        Bed temp = new Bed();
       // if(departments.get(oddzial).showRooms().size() > )
        for(Room room: departments.get(oddzial).showRooms()){
            for(Bed bed: room.getBeds()){
                if(bed.getPatient() == null){
                    Patient patient = new Patient(imie, nazwisko, oddzial, pesel);
                    departments.get(oddzial).addPatient(patient);
                    patients.add(patient);
                    bed.assignPatient(patient);
                    System.out.println("Umieszczono pacjenta na oddziale nr " + oddzial + " w pokoju nr "+ room.getId());
                    return;
                }
            }
        }
        System.out.println("Brak wolnych miejsc w wybranym oddziale");
    }

    public static void NurseMenu(){
        final String choice = "== MENU PIELEGNIARKI== \n 1. Wyszukaj informacje o oddziale \n 2. Dodaj pacjenta";
        int response = 0;
        do{
            response = Integer.parseInt(GetUserResponse(choice));
            switch(response){
                case 1:
                    showDepartmentInfo();
                    break;

                case 2:
                    putPatientInfo();
                    break;
            }
        }while(response!=0);


    }

    public static void ReceptionistMenu(){
        final String choice = "== MENU PRACOWNIKA IZBY PRZYJEC  == \n 1. Wyszukaj informacje o oddziale \n 2. Pokaz pokoje ";
        int response = Integer.parseInt(GetUserResponse(choice));
        switch(response){
            case 1:
                showDepartmentInfo();
                break;

            case 2:
               // putPatientInfo();
                break;
        }
    }
}
