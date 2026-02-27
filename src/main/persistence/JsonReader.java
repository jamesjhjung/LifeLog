package persistence;

import java.io.IOException;

import org.json.JSONObject;

import model.LifeLog;
import model.LogEntry;

// Represents a reader that reads LifeLog data from JSON stored in file
public class JsonReader {

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        // stub
    }

    // EFFECTS: reads LifeLog from file and returns it
    //          throws IOException if an error occurs while reading
    public LifeLog read() throws IOException {
        return null; // stub
    }

    // EFFECTS: parses LifeLog from JSON object and returns it
    private LifeLog parseLifeLog(JSONObject jsonObject) {
        return null; // stub
    }

    // MODIFIES: log
    // EFFECTS: parses entries from JSON object and adds them to log
    private void addEntries(LifeLog log, JSONObject jsonObject) {
        // stub
    }

    // EFFECTS: parses LogEntry from JSON object and returns it
    private LogEntry parseEntry(JSONObject jsonObject) {
        return null; // stub
    }
}
