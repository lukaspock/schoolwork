package at.htlpinkafeld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SorterTestSOP {
    Sorter sorter = new Sorter();
    Comparable[] objects = new Comparable[4];

    @BeforeEach
    void setUp() {
        this.objects[3] = new SheetOfPaper(1);
        this.objects[2] = new Car("Audi", 2010, 200, 4235, 1820, 1650);
        this.objects[1] = new SoccerField();
        this.objects[0] = new SheetOfPaper(4);
    }


    @Test
    void getMinimum() {
        System.out.println(sorter.getMinimum(this.objects));
        assertEquals(this.objects[3], sorter.getMinimum(this.objects));
    }

    @Test
    void getMaximum() {
        System.out.println(sorter.getMaximum(this.objects));
        assertEquals(this.objects[3], sorter.getMaximum(this.objects));
    }

    @Test
    void bubbleSort() {
        sorter.bubbleSort(this.objects);

        Comparable[] expected = new Comparable[4];

        expected[0] = new SheetOfPaper(4);
        expected[1] = new SoccerField();
        expected[2] = new Car("Audi", 2010, 200, 4235, 1820, 1650);
        expected[3] = new SheetOfPaper(1);

        System.out.println("Result: " + Arrays.toString(this.objects));
        System.out.println("Expected: " + Arrays.toString(expected));

        assertArrayEquals(expected, this.objects);
    }
}