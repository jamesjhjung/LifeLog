package model;

import java.time.LocalDate;

/*
 * Represents a single record in the LifeLog application.
 * A LogEntry captures information about one logged activity,
 * including its title, category, optional description,
 * number of hours spent, and the date on which it occurred.
 *
 * LogEntry objects are managed by the LifeLog class.
 */

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
        this.title = title;
        this.category = category;
        this.description = description;
        this.hours = hours;
        this.date = date;
    }

    // EFFECTS: returns string representation of this entry
    public String toString() {
        String entryString = 
        title + " | " + 
        category + " | " + 
        description + " | " + 
        Double.toString(hours) + " Hours" 
        + " | " + date.toString();
        return entryString;
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
