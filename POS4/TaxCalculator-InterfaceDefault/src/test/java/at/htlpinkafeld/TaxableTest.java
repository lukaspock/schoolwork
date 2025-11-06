package at.htlpinkafeld;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxableTest {

    @BeforeEach
    void setUp() {
        Taxable t1 = new Taxable() { @Override public double getTax() { return 1.0; } };
        Taxable t2 = new Taxable() { @Override public double getTax() { return 1.0; } };

        assertEquals(0, t1.compareTo(t2));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCompareToGreater() {
        Taxable t1 = new Taxable() { @Override public double getTax() { return 2.0; } };
        Taxable t2 = new Taxable() { @Override public double getTax() { return 1.0; } };

        assertTrue(t1.compareTo(t2) > 0);
    }

    @Test
    void testCompareToSmaller() {
        Taxable t1 = new Taxable() { @Override public double getTax() { return 0.5; } };
        Taxable t2 = new Taxable() { @Override public double getTax() { return 1.0; } };

        assertTrue(t1.compareTo(t2) < 0);
    }

    @Test
    void testCompareToCloseValuesNotEqual() {
        Taxable t1 = new Taxable() { @Override public double getTax() { return 1.0000001; } };
        Taxable t2 = new Taxable() { @Override public double getTax() { return 1.0; } };

        assertTrue(t1.compareTo(t2) > 0);
        assertTrue(t2.compareTo(t1) < 0);
    }

    @Test
    void testCompareToNull() {
        Taxable t1 = new Taxable() { @Override public double getTax() { return 1.0; } };

        assertEquals(-1, t1.compareTo(null));
    }

    @Test
    void testCompareToNonTaxableObject() {
        Taxable t1 = new Taxable() { @Override public double getTax() { return 1.0; } };
        Object notTaxable = new Object();

        assertEquals(-1, t1.compareTo(notTaxable));
}

}