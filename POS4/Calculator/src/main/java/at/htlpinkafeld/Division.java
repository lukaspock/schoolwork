package at.htlpinkafeld;

public class Division implements Operator{
    @Override
    public double calculate(double a, double b) {
        return a / b;
    }
}
