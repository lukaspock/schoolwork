package at.htlpinkafeld.DoubleMethod;

public class Exponential implements DoubleMethod {
    private int exponent;

    public Exponential(int exponent) {
        this.exponent = exponent;
    }
    public double compute(double value) {
        return Math.pow(value,exponent);
    }
}
