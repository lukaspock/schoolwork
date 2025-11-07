package at.htlpinkafeld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    private Circle circle;

    @BeforeEach
    void setUp() {
        this.circle = new Circle(5.00);
    }

    @Test
    void getArea() {
        assertEquals(78.54,this.circle.getArea(),0.0001);
    }
}