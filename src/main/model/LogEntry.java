package model;

import java.time.LocalDate;

public class LogEntry {
    private String title;
    private String category;
    private String description;
    private double hours;
    private LocalDate date;

    // REQUIRES: title and category are non-empty
    //           hours >= 0
    // EFFECTS: constructs a LogEntry object with given fields
    public LogEntry(String title, String category, String description, double hours, LocalDate date) {
        // stub
    }

    // EFFECTS: returns true if this.category matches given category
    public boolean matchesCategory(String category) {
        return false; // stub
    }

    // EFFECTS: returns string representation of this entry
    public String toString() {
        return null; // stub
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
