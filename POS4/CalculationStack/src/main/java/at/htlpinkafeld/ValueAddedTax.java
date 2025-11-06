package at.htlpinkafeld;

public class ValueAddedTax implements Calculation{
    double taxRate;
    double netPrice;

    public ValueAddedTax(double taxRate, double netPrice) {
        this.taxRate = taxRate;
        this.netPrice = netPrice;
    }

    public ValueAddedTax(ValueAddedTax vta) {
        this.taxRate = vta.taxRate;
        this.netPrice = vta.netPrice;
    }

    @Override
    public String toString() {
        return "ValueAddedTax{" +
                "taxRate=" + taxRate +
                ", netPrice=" + netPrice +
                '}';
    }

    @Override
    public double calculate(){
        return taxRate*netPrice;
    }
}
