package Interface;

import Main.ApplicationInstance;
import Users.Doctor;

import java.util.Scanner;

public class UI {

    public static String GetUserResponse(String command){
        Scanner scanner = new Scanner(System.in);
        System.out.println(command);
        String response = scanner.nextLine();
        return response;
    }
    public static void StartMenu(){
        String response;
        int num_response;
        final String start = "============== SYSTEM ZARZADZANIA SZPITALEM ============== \n === STRONA GLOWNA ===";
        System.out.println(start);

        final String role_choice = " 1. Wybor uprawnien \n 2. Wyjdz";
        response = GetUserResponse(role_choice);
        int choice = RoleChoice();
        switch(choice){
            case 1: // lekarz
                DoctorsMenu();
                break;

            case 2: // pielegniarka
                break;

            case 3: // Pracownik izby przyjec
                break;
        }

    }

    public static int RoleChoice(){
        String roles = "== WYBOR UPRAWNIEN == \n 1. Lekarz \n 2. Pielegniarka \n 3. Pracownik izby przyjec";
        int num_response = Integer.parseInt(GetUserResponse(roles));
        return num_response;
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
}
