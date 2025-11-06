package at.htlpinkafeld;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc;

    @Test
    void calculateAddition() {
        calc = new Calculator(new Addition());
        assertEquals(3.0,calc.calculate(1.0, 2.0));
    }

    @Test
    void calculateSubstraction() {
        calc = new Calculator(new Subtraction());
        assertEquals(-1, calc.calculate(1.0, 2.0));
    }

    @Test
    void calculateMultiplication() {
        calc = new Calculator(new Multiplication());
        assertEquals(3.0, calc.calculate(1.0, 3.0));
    }

    @Test
    void calculateDivision() {
        calc = new Calculator(new Division());
        assertEquals(1.0, calc.calculate(3.0, 3.0));
    }


}