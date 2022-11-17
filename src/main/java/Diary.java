import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diary {

    private static final Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
    static LocalDate localDate = LocalDate.now();
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Path path = Paths.get("src/main/resources/entries.json");
    private static List<Entry> allEntries = new ArrayList<>();

    static {
        try {
            allEntries = List.of(mapper.readValue(path.toFile(), Entry[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Different methods
     */

    static Entry newEntry() {
        System.out.println("Skriv in en titel");
        String title = scanner.nextLine();
        System.out.println("Börja skriva ditt inlägg");
        String text = scanner.nextLine();
        String date = dtf.format(localDate).toString();
        return new Entry(title, text, date);
    }

    public static void addEntry() throws IOException {

        allEntries = List.of(mapper.readValue(path.toFile(), Entry[].class));
        List<Entry> entries = new ArrayList<>(allEntries);
        entries.add(newEntry());
        mapper.writeValue(path.toFile(), entries);
    }

    public static void printEntries() throws IOException {
        List<Entry> entriesJSONUpdated = List.of(mapper.readValue(path.toFile(), Entry[].class));
        for (Entry entry : entriesJSONUpdated) {
            searchEntries();
        }
    }

    static void searchEntries() {

        for (Entry entry : allEntries) {
            System.out.println("Titel - " + entry.getTitle());
            System.out.println("Inlägg - " + entry.getText());
            System.out.println("Datum - " + entry.getDate());
        }
        if (allEntries.size() < 1){
            System.out.println("Inga inlägg hittades");
        }
        backToMenu();
    }

    public static void backToMenu() {
        System.out.println("Tryck enter för att gå till meny");
        try {
            System.in.read();
            //mainMenu();
        } catch (Exception e) {
        }
    }
}