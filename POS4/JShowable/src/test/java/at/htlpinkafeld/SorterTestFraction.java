package at.htlpinkafeld;

import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    Sorter sorter = new Sorter();
    Comparable[] objects = new Comparable[4];

    @BeforeEach
    void setUp() {
        objects[0] = new Fraction(100,100);
        objects[1] = new Fraction(87,100);
        objects[2] = new Fraction(60,100);
        objects[3] = new Fraction(200,100);
    }

    @org.junit.jupiter.api.Test
    void getMinimum() {
        System.out.println("Result: " + sorter.getMinimum(objects));
        assertEquals(objects[2],sorter.getMinimum(objects));
    }

    @org.junit.jupiter.api.Test
    void getMaximum() {
        System.out.println("Result: " + sorter.getMaximum(objects));
        assertEquals(objects[3],sorter.getMaximum(objects));
    }

    @org.junit.jupiter.api.Test
    void bubbleSort() {

        sorter.bubbleSort(this.objects);
        System.out.println("Result: " + Arrays.toString(this.objects));

        Comparable[] expected = new Comparable[4];
        expected[0] = new Fraction(60,100);
        expected[1] = new Fraction(87,100);
        expected[2] = new Fraction(100,100);
        expected[3] = new Fraction(200,100);

        System.out.println("Actual: " + Arrays.toString(expected));

        assertArrayEquals(expected, this.objects);
    }
}

