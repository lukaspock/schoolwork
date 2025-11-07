package at.htlpinkafeld.INTMemory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class INTMemoryTest {

    private INTMemory memory;

    @BeforeEach
    void setUp(){
        memory = new INTMemory(10);
    }

    @AfterEach
    void tearDown(){
        memory = null;
    }

    @Test
    void testGetValue() {
        assertEquals(10, memory.getValue());
    }

    @Test
    void testSetValue() {
        memory.setValue(20);
        assertEquals(20, memory.getValue());
    }

    @Test
    void testAddValue() {
        memory.addValue(5);
        assertEquals(15, memory.getValue());
    }

    @Test
    void testJoin() {
        INTMemory intMemory2 = new INTMemory(10);
        INTMemory intmemory3 = memory.join(intMemory2);

        assertEquals(20, intmemory3.getValue());
    }
}