package at.htlpinkafeld;

public class TaxableDefault implements Taxable{
    private Taxable taxable;

    public TaxableDefault(Taxable taxable) {
        this.taxable = taxable;
    }

    public TaxableDefault() {
        this.taxable = this;
    }

    @Override
    public double getTax() { return 0; }

}
