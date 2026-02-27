package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

import org.json.JSONObject;
import org.json.JSONArray;

import model.LifeLog;
import model.LogEntry;

// Represents a reader that reads LifeLog data from JSON stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads LifeLog from file and returns it
    //          throws IOException if an error occurs while reading
    public LifeLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLifeLog(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it;
    //          throws IOException if an error occurs reading from file
    private String readFile(String source) throws IOException {
        StringBuilder content = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(content::append);
        }

        return content.toString();
    }

    // EFFECTS: parses LifeLog from JSON object and returns it
    private LifeLog parseLifeLog(JSONObject jsonObject) {
        LifeLog log = new LifeLog();
        addEntries(log, jsonObject);
        return log;
    }

    // MODIFIES: log
    // EFFECTS: parses entries from JSON object and adds them to log
    private void addEntries(LifeLog log, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("entries");

        for (Object o : jsonArray) {
            JSONObject entryJson = (JSONObject) o;
            LogEntry entry = parseEntry(entryJson);
            log.addEntry(entry);
        }
    }

    // EFFECTS: parses LogEntry from JSON object and returns it
    private LogEntry parseEntry(JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String category = jsonObject.getString("category");
        String description = jsonObject.getString("description");
        double hours = jsonObject.getDouble("hours");
        LocalDate date = LocalDate.parse(jsonObject.getString("date"));

        return new LogEntry(title, category, description, hours, date);
    }
}
