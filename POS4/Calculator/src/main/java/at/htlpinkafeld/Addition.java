package at.htlpinkafeld;

public class Addition implements Operator {
    @Override
    public double calculate(double a, double b) {
        return a+b;
    }
}
