package at.htlpinkafeld;

public class FlatRate implements FeeStrategy{
    public enum Modus {ECO,COMFORT,PREMIUM};

    private int[] limits = {1500,3000,5000};            //limits for different modi
    private double[] basicFees = {9.99, 14.99, 19.99};  //basic fees for the modi
    private double[] fee = {0.05, 0.04, 0.025};         //fees for different modi
    private Modus modus;

    public FlatRate(Modus m){
        modus = m;
    }
    @Override
    public double getFee(int usedMinutes) {
        double result = basicFees[modus.ordinal()];
        if(result > limits[modus.ordinal()]){
            result += fee[modus.ordinal()] * (usedMinutes - limits[modus.ordinal()]);
        }
        return result;
    }
}
