package persistence;

import java.io.FileNotFoundException;

import org.json.JSONObject;

import model.LifeLog;

// Represents a writer that writes LifeLog objects to a JSON file
public class JsonWriter {
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of lifeLog to file
    public void write(LifeLog lifeLog) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot be opened
    public void open() throws FileNotFoundException {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        // stub
    }
}
