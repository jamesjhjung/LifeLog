package ui;

import model.LifeLog;
import model.LogEntry;

import java.time.LocalDate;
import java.util.Scanner;

public class LifeLogApp {

    private LifeLog lifeLog;
    private Scanner scanner;

    public LifeLogApp() {
        lifeLog = new LifeLog();
        scanner = new Scanner(System.in);
        runApp();
    }

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
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nLifeLog Menu:");
        System.out.println("1 - Add Entry");
        System.out.println("2 - Remove Entry");
        System.out.println("3 - View All Entries");
        System.out.println("4 - View Entries by Date");
        System.out.println("5 - View Entries by Category");
        System.out.println("6 - View Total Hours");
        System.out.println("7 - Quit");
        System.out.print("Select option: ");
    }

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

    private void removeEntry() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        lifeLog.removeEntry(title, date);

        System.out.println("Remove operation complete.");
    }

    private void viewEntries() {
        for (LogEntry e : lifeLog.getEntries()) {
            System.out.println(e);
        }
    }

    private void viewEntriesByDate() {
        System.out.print("Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        LocalDate dateFormatted = LocalDate.parse(date);
        for (LogEntry e : lifeLog.getEntriesByDate(dateFormatted)) {
            System.out.println(e);
        }
    }

    private void viewEntriesByCategory() {
        System.out.print("Category: ");
        String category = scanner.nextLine();

        for (LogEntry e : lifeLog.getEntriesByCategory(category)) {
            System.out.println(e);
        }
    }

    private void viewTotalHours() {
        double totalHours = lifeLog.getTotalHours();
        System.out.println("Total hours logged: " + totalHours);

    }
}
