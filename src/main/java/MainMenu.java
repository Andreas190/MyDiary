import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String choice = "0";
        /**
         * Main loop. */
            while (!choice.equals("3")) {
                    System.out.println("");
                    System.out.println("Välj ett alternativ och tryck Enter");
                    System.out.println("1: Skriv ett inlägg.");
                    System.out.println("2: Läs tidigare inlägg");
                    System.out.println("3: Avsluta programmet");
                    choice = scanner.nextLine();
                    System.out.println("");

                switch (choice) {
                    case "1":
                        Diary.addEntry();
                        break;
                    case "2":
                        Diary.searchEntries();
                        break;
                    case "3":
                        System.out.println("Programmet avslutas. Hej då!");
                        break;
                    default:
                        System.out.println("Fel! Välj alternativ 1, 2 eller 3");

            }
        }
    }
}