package at.htlpinkafeld;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {
    TaxCalculator taxCalculator = new TaxCalculator();
    Taxable[] list = new Taxable[4];

    @BeforeEach
    void setUp(){
        this.list[0] = new Clerk("Posch",2.0);
        this.list[1] = new Clerk("Zach",20.0);
        this.list[2] = new Worker("Vortschi",40.0);
        this.list[3] = new Worker("Justin",30.0);
    }

    @org.junit.jupiter.api.Test
    void getTaxTotal() {

    }

    @org.junit.jupiter.api.Test
    void getLargestTaxElement() {
    }

    @org.junit.jupiter.api.Test
    void getSortedList() {
    }
}