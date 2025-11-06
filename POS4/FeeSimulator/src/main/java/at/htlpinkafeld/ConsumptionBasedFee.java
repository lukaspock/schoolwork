package at.htlpinkafeld;

public class ConsumptionBasedFee implements FeeStrategy {

    private double consumptionBasedFee;

    public ConsumptionBasedFee(double consumptionBasedFee) {
        this.consumptionBasedFee = consumptionBasedFee;
    }

    @Override
    public double getFee(int usedMinutes) {
        return consumptionBasedFee * usedMinutes;
    }
}
