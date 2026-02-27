package persistence;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.LifeLog;
import model.LogEntry;

import java.io.IOException;

@ExcludeFromJacocoGeneratedReport
public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        assertThrows(IOException.class, reader::read);
    }

    @Test
    void testReaderEmptyLifeLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyLifeLog.json");
        try {
            LifeLog log = reader.read();
            assertEquals(0, log.getEntries().size());
        } catch (IOException e) {
            fail ("Exception should not have been thrown");
        }
    }

    @Test
    void testReaderGeneralLifeLog() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralLifeLog.json");
        try {
            LifeLog log = reader.read();
            assertEquals(2, log.getEntries().size());

            LogEntry e1 = log.getEntries().get(0);
            assertEquals("Gym", e1.getTitle());
            assertEquals("Health", e1.getCategory());
            assertEquals(2.0, e1.getHours());

            LogEntry e2 = log.getEntries().get(1);
            assertEquals("Study", e2.getTitle());
            assertEquals("School", e2.getCategory());
            assertEquals(3.5, e2.getHours());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
