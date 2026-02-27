package persistence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.LifeLog;
import model.LogEntry;
import java.time.LocalDate;

import java.io.IOException;

public class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    void testWriterEmptyLifeLog() {
        try {
            LifeLog log = new LifeLog();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyLifeLog.json");
            writer.open();
            writer.write(log);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyLifeLog.json");
            log = reader.read();
            assertEquals(0, log.getEntries().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralLifeLog() {
        try {
            LifeLog log = new LifeLog();
            log.addEntry(new LogEntry("Study", "School", "CPSC-210", 2, LocalDate.of(2025, 2, 1)));
            log.addEntry(new LogEntry("Gym", "Health", "Leg day", 1, LocalDate.of(2025, 2, 2)));

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralLifeLog.json");
            writer.open();
            writer.write(log);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralLifeLog.json");
            log = reader.read();

            assertEquals(2, log.getEntries().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
