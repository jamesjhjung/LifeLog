package model;

import java.time.LocalDate;
import java.util.ArrayList;

/*
 * Represents a collection of LogEntry objects.
 * A LifeLog stores and manages an arbitrary number
 * of activity entries, and provides functionality to
 * add, remove, edit, and query logged activities.
 *
 * The LifeLog serves as the central model of the
 * application and maintains the state of all entries.
 */

public class LifeLog {
    private ArrayList<LogEntry> entries;

    // EFFECTS: construcs a LifeLog object
    public LifeLog() {
        entries = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds given entry to log
    public void addEntry(LogEntry entry) {
        entries.add(entry);
    }

    // MODIFIES: this
    // EFFECTS: removes first entry with matching given title
    //          and date, does nothing if no match is found
    public void removeEntry(String title, LocalDate date) {
        for (int i = 0; i < entries.size(); i++) {
            LogEntry e = entries.get(i);
            if (e.getTitle().equals(title) && e.getDate().equals(date)) {
                entries.remove(i);
                break;
            }
        }
    }

    // EFFECTS: returns list of entries in added order
    public ArrayList<LogEntry> getEntries() {
        return entries;
    }

    // EFFECTS: returns list of entries added in
    //          order of given category in log
    public ArrayList<LogEntry> getEntriesByCategory(String category) {
        ArrayList<LogEntry> categoryEntries = new ArrayList<>();
        for (LogEntry e : entries) {
            if (e.getCategory().equals(category)) {
                categoryEntries.add(e);
            }
        }
        return categoryEntries;
    }

    // EFFECTS: returns list of entries added in
    //          order of given date in log
    public ArrayList<LogEntry> getEntriesByDate(LocalDate date) {
        ArrayList<LogEntry> dateEntries = new ArrayList<>();
        for (LogEntry e : entries) {
            if (e.getDate().equals(date)) {
                dateEntries.add(e);
            }
        }
        return dateEntries;
    }

    // EFFECTS: returns total hours spent across 
    //          all entries
    public double getTotalHours() {
        double totalHours = 0.0;
        for (LogEntry e : entries) {
            totalHours += e.getHours();
        }
        return totalHours;
    }
    
    // EFFECTS: returns total hours spent in given
    //          category, returns 0 if no match
    public double getTotalHoursByCategory(String category) {
        double categoryTotalHours = 0.0;
        for (LogEntry e : entries) {
            if (e.getCategory().equals(category)) {
                categoryTotalHours += e.getHours();
            }
        }
        return categoryTotalHours;
    }    
}
