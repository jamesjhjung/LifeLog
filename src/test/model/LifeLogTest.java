package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifeLogTest {

    private LifeLog testLog;
    private LogEntry e1;
    private LogEntry e2;
    private LogEntry e3;
    
    @BeforeEach
    void runBefore() {
        testLog = new LifeLog();

        e1 = new LogEntry("Gym", "Health", "Chest Day",
                2.0, LocalDate.of(2026, 2, 10));

        e2 = new LogEntry("Study", "School", "CPSC-210",
                3.5, LocalDate.of(2026, 2, 11));

        e3 = new LogEntry("Run", "Health", "Morning run",
                1.0, LocalDate.of(2026, 2, 11));
    }

    @Test
    void testConstructor() {
        assertEquals(0, testLog.getEntries().size());
    }

    @Test
    void testAddEntry() {
        assertEquals(0, testLog.getEntries().size());
        testLog.addEntry(e1);
        assertEquals(1, testLog.getEntries().size());
        assertEquals(e1, testLog.getEntries().get(0));
    }

    @Test
    void testRemoveEntryMatch() {
        testLog.addEntry(e1);
        assertEquals(1, testLog.getEntries().size());
        assertEquals(e1, testLog.getEntries().get(0));
        testLog.removeEntry("Gym", LocalDate.of(2026, 2, 10));
        assertEquals(0, testLog.getEntries().size());
    }

    @Test
    void testRemoveEntryNoTitleMatch() {
        testLog.addEntry(e1);
        assertEquals(1, testLog.getEntries().size());
        assertEquals(e1, testLog.getEntries().get(0));
        testLog.removeEntry("Sleep", LocalDate.of(2026, 2, 10));
        assertEquals(1, testLog.getEntries().size());
        assertEquals(e1, testLog.getEntries().get(0));
    }

    @Test
    void testRemoveEntryNoDateMatch() {
        testLog.addEntry(e1);
        assertEquals(1, testLog.getEntries().size());
        assertEquals(e1, testLog.getEntries().get(0));
        testLog.removeEntry("Gym", LocalDate.of(2026, 2, 15));
        assertEquals(1, testLog.getEntries().size());
        assertEquals(e1, testLog.getEntries().get(0));
    }

    @Test
    void testRemoveEntryNoBothMatch() {
        testLog.addEntry(e1);
        assertEquals(1, testLog.getEntries().size());
        assertEquals(e1, testLog.getEntries().get(0));
        testLog.removeEntry("Sleep", LocalDate.of(2026, 2, 15));
        assertEquals(1, testLog.getEntries().size());
        assertEquals(e1, testLog.getEntries().get(0));
    }

    @Test
    void testGetEntriesByCategory() {
        testLog.addEntry(e1);
        testLog.addEntry(e2);
        testLog.addEntry(e3);

        ArrayList<LogEntry> healthEntries = testLog.getEntriesByCategory("Health");
        assertEquals(2, healthEntries.size());
        assertEquals(e1, healthEntries.get(0));
        assertEquals(e3, healthEntries.get(1));

        ArrayList<LogEntry> schoolEntries = testLog.getEntriesByCategory("School");
        assertEquals(1, schoolEntries.size());
        assertEquals(e2, schoolEntries.get(0));
    }

    @Test
    void testGetTotalHours() {
        assertEquals(0, testLog.getTotalHours());
        testLog.addEntry(e1);
        testLog.addEntry(e2);
        testLog.addEntry(e3);
        assertEquals(6.5, testLog.getTotalHours());
    }

    @Test
    void testGetToalHoursByCategory() {
        testLog.addEntry(e1);
        testLog.addEntry(e2);
        testLog.addEntry(e3);
        assertEquals(3.0, testLog.getTotalHoursByCategory("Health"));
        assertEquals(3.5, testLog.getTotalHoursByCategory("School"));
    }
}
