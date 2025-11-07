package at.htlpinkafeld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Triangle triangle;

    @BeforeEach
    void setUp() {
        this.triangle = new Triangle(3.00,4.00,5.00);
    }

    @Test
    void testGetArea() {
        assertEquals(6.00, this.triangle.getArea(), 0.0001);


    }
}