package at.htlpinkafeld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private Rectangle rectangle;

    @BeforeEach
    public void setup(){
        this.rectangle = new Rectangle(9.00,5.00);
    }

    @Test
    void getArea() {
        assertEquals(45.00,this.rectangle.getArea(), 0.0001);
    }
}