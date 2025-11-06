package at.htlpinkafeld.Comparators;

import at.htlpinkafeld.Sorter.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ToStringComparatorTest {
    Object[] strings;
    Sorter sorter = new Sorter(new ToStringComparator());

    @BeforeEach
    void setUp() {
        strings = new Object[]{"D","C","B","A"};
    }

    @Test
    void comareMin(){
        assertEquals(sorter.getMinimum(strings), strings[3]);
    }

    @Test
    void comareMax(){
        assertEquals(sorter.getMaximum(strings), strings[0]);
    }

    @Test
    void sort(){
        sorter.sort(strings);
        String[] expected = {"A","B","C","D"};
        assertEquals(Arrays.toString(strings), Arrays.toString(expected));
    }
}