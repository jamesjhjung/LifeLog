package ui;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import model.LifeLog;
import model.LogEntry;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.time.LocalDate;
import java.util.Scanner;

@ExcludeFromJacocoGeneratedReport
// Represents the LifeLog application for main UI
public class LifeLogApp {

    private LifeLog lifeLog;
    private Scanner scanner;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final String JSON_STORE = "./data/lifelog.json";

    // MODIFIES: this
    // EFFECTS:  constructs a LifeLogApp object, initializes LifeLog, Scanner,
    //           JsonReader, JsonWriter and starts the command-line application
    public LifeLogApp() {
        lifeLog = new LifeLog();
        scanner = new Scanner(System.in);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        runApp();
    }

    @SuppressWarnings("methodlength")
    // MODIFIES: this
    // EFFECTS:  runs the main application loop, displaying menu options and
    //           responding to user commands until the user chooses to quit
    private void runApp() {
        boolean running = true;
        while (running) {
            displayMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addEntry();
                    break;
                case "2":
                    removeEntry();
                    break;
                case "3":
                    viewEntries();
                    break;
                case "4":
                    viewEntriesByDate();
                    break;
                case "5":
                    viewEntriesByCategory();
                    break;
                case "6":
                    viewTotalHours();
                    break;
                case "7":
                    saveLifeLog();
                    break;
                case "8":
                    loadLifeLog();
                    break;
                case "9":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // EFFECTS:  prints the main menu for the LifeLog app to the console
    private void displayMenu() {
        System.out.println("\nLifeLog Menu:");
        System.out.println("1 - Add Entry");
        System.out.println("2 - Remove Entry");
        System.out.println("3 - View All Entries");
        System.out.println("4 - View Entries by Date");
        System.out.println("5 - View Entries by Category");
        System.out.println("6 - View Total Hours");
        System.out.println("7 - Save LifeLog");
        System.out.println("8 - Load LifeLog");
        System.out.println("9 - Quit");
        System.out.print("Select option: ");
    }

    // REQUIRES: user inputs - non-empty title, non-empty category,
    //                         hours >= 0, date in YYYY-MM-DD format
    // MODIFIES: lifeLog
    // EFFECTS:  prompts user for LogEntry details, constructs a LogEntry,
    //           and adds to lifeLog. Prints confirmation of addition
    private void addEntry() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Hours: ");
        double hours = Double.parseDouble(scanner.nextLine());

        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        LogEntry entry = new LogEntry(title, category, description, hours, date);
        lifeLog.addEntry(entry);

        System.out.println("Entry added.");
    }

    // REQUIRES: user inputs valid title and date in YYYY-MM-DD format
    // MODIFIES: lifeLog
    // EFFECTS:  removes the first LogEntry in lifeLog that matches the given
    //           title and date. Prints confirmation of removal
    private void removeEntry() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        lifeLog.removeEntry(title, date);

        System.out.println("Remove operation complete.");
    }

    // EFFECTS:  prints all LogEntry objects stored in lifeLog in order added
    private void viewEntries() {
        for (LogEntry e : lifeLog.getEntries()) {
            System.out.println(e);
        }
    }

    // REQUIRES: user inputs date in YYYY-MM-DD format
    // EFFECTS:  prints all LogEntry objects in lifeLog matching the given date.
    private void viewEntriesByDate() {
        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        LocalDate dateFormatted = LocalDate.parse(date);
        for (LogEntry e : lifeLog.getEntriesByDate(dateFormatted)) {
            System.out.println(e);
        }
    }

    // REQUIRES: user inputs non-empty category string
    // EFFECTS:  prints all LogEntry objects in lifeLog matching given string
    private void viewEntriesByCategory() {
        System.out.print("Category: ");
        String category = scanner.nextLine();

        for (LogEntry e : lifeLog.getEntriesByCategory(category)) {
            System.out.println(e);
        }
    }

    // EFFECTS:  calculates and prints the total hours of all LogEntry objects
    //           in lifeLog
    private void viewTotalHours() {
        double totalHours = lifeLog.getTotalHours();
        System.out.println("Total hours logged: " + totalHours);

    }

    // MODIFIES: JSON_STORE file
    // EFFECTS:  saves the current LifeLog object to JSON_STORE using JsonWriter.
    //           prints success or failure message
    private void saveLifeLog() {
        try {
            jsonWriter.open();
            jsonWriter.write(lifeLog);
            jsonWriter.close();
            System.out.println("LifeLog saved successfully.");
        } catch (Exception e) {
            System.out.println("Unable to save LifeLog.");
        }
    }

    // MODIFIES: this, lifeLog
    // EFFECTS:  load the LifeLog object from JSON_STORE using JsonReader and
    //           replaces the current lifeLog. Prints success or failure message.
    private void loadLifeLog() {
        try {
            lifeLog = jsonReader.read();
            System.out.println("LifeLog loaded successfully.");
        } catch (Exception e) {
            System.out.println("Unable to load LifeLog.");
        }
    }
}
