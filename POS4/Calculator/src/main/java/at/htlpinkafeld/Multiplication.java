package at.htlpinkafeld;

public class Multiplication implements Operator {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}
