package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogEntryTest {

    private LogEntry testEntry;
    
    @BeforeEach
    void runBefore() {
        testEntry = new LogEntry(
            "Gym", 
            "Health", 
            "Back Day", 
            1, 
            LocalDate.of(2026, 2, 12)
        );
    }

    @Test
    void testConstructor() {
        assertEquals("Gym", testEntry.getTitle());
        assertEquals("Health", testEntry.getCategory());
        assertEquals("Back Day", testEntry.getDescription());
        assertEquals(1, testEntry.getHours());
        assertEquals(LocalDate.of(2026, 2, 12), testEntry.getDate());
    }

    @Test
    void testMatchesCategory() {
        assertTrue(testEntry.matchesCategory("Health"));
        assertFalse(testEntry.matchesCategory("work"));
    }

    @Test
    void testToString() {
        assertEquals("Gym | Health | Back Day | 1 Hours | 2026-02-12", testEntry.toString());
    }

    @Test
    void testSettersAndGetters() {
        testEntry.setTitle("Homework");
        testEntry.setCategory("School");
        testEntry.setDescription("CPSC-210");
        testEntry.setHours(2);
        testEntry.setDate(LocalDate.of(2011, 1, 11));
        assertEquals("Homework", testEntry.getTitle());
        assertEquals("School", testEntry.getCategory());
        assertEquals("CPSC-210", testEntry.getDescription());
        assertEquals(2, testEntry.getHours());
        assertEquals(LocalDate.of(2011, 1, 11), testEntry.getDate());
    }
}
