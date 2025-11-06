package at.htlpinkafeld;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class IntStackTest {

    IntStack intStack;

    @BeforeEach
    void setUp(){
        intStack = new IntStack(10);
    }

    @org.junit.jupiter.api.Test
    void testGetSize() {
        assertEquals(10, intStack.getSize());
    }

    @org.junit.jupiter.api.Test
    void testGetEleCnt() {
        assertEquals(0, intStack.getEleCnt());
    }

    @org.junit.jupiter.api.Test
    void testPush() {
        intStack.push(1);
        intStack.push(2);
        assertEquals(2, intStack.getEleCnt());
    }

    @org.junit.jupiter.api.Test
    void isFull() {
        assertFalse(intStack.isFull());
    }

    @org.junit.jupiter.api.Test
    void pop() {
        intStack.push(1);
        intStack.push(2);
        assertEquals(2, intStack.pop());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(intStack.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        intStack.push(1);
        intStack.push(2);
        assertEquals(2, intStack.peek());
    }

    @org.junit.jupiter.api.Test
    void resize() {
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);
        assertEquals(false, intStack.resize(2));
    }
}