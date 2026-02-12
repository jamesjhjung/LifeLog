package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class LifeLog {
    private ArrayList<LogEntry> entries;

    // EFFECTS: construcs a LifeLog object
    public LifeLog() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: adds given entry to log
    public void addEntry(LogEntry entry) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: removes first entry with matching given title
    //          and date, does nothing if no match is found
    public void removeEntry(String title, LocalDate date) {
        // stub
    }

    // EFFECTS: returns list of entries in added order
    public ArrayList<LogEntry> getEntries() {
        return null; // stub
    }

    // EFFECTS: returns list of entries added in
    //          order of given category in log
    public ArrayList<LogEntry> getEntriesByCategory(String category) {
        return null; // stub
    }

    // EFFECTS: returns total hours spent in given
    //          category, returns 0 if no match
    public double getTotalHoursByCategory(String category) {
        return 0; // stub
    }

    // EFFECTS: returns total hours spent across 
    //          all entries
    public double getTotalHours() {
        return 0; // stub
    }
}
