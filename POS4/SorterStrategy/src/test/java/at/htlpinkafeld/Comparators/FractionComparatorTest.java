package at.htlpinkafeld.Comparators;

import at.htlpinkafeld.Classes.Fraction;
import at.htlpinkafeld.Sorter.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FractionComparatorTest {
    Object[] fractions;
    Sorter sorter = new Sorter(new FractionComparator());

    @BeforeEach
    void setUp() {
        fractions = new Object[]{new Fraction(1,2),new Fraction(3,4),new Fraction(5,6)};
    }

    @org.junit.jupiter.api.Test
    void compareMin() {
        assertEquals(sorter.getMinimum(fractions), fractions[0]);
    }

    @org.junit.jupiter.api.Test
    void compareMax() {
        assertEquals(sorter.getMaximum(fractions), fractions[2]);
    }

    @Test
    void sort(){
        sorter.sort(fractions);
        Fraction[] expected = new Fraction[]{new Fraction(1,2),new Fraction(3,4),new Fraction(5,6)};
        assertEquals(Arrays.toString(fractions), Arrays.toString(expected));
    }
}