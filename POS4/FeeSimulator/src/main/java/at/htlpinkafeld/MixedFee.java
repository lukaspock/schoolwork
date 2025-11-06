package at.htlpinkafeld;

public class MixedFee implements FeeStrategy {

    private double basicFee;
    private double consumptionBasedFee;

    MixedFee(double basicFee, double consumptionBasedFee) {
        this.basicFee = basicFee;
        this.consumptionBasedFee = consumptionBasedFee;
    }

    @Override
    public double getFee(int usedMinutes) {
        return basicFee + consumptionBasedFee * usedMinutes;
    }
}
