package at.htlpinkafeld;

public class TaxCalculator {
    Taxable[] taxableList;

    public double getTaxTotal(){
        double total = 0;
        for(Taxable t:taxableList){
            total += t.getTax();
        }
        return total;
    }

    public Taxable getLargestTaxElement(){
        Taxable largestTaxElement = null;
        for(Taxable t:taxableList){
            if(t.getTax() > this.getTaxTotal()){
                largestTaxElement = t;
            }
        }
        return largestTaxElement;
    }

    public Object[] getSortedList(){
        for(int i = 0; i < taxableList.length; i++){
            for(int j = 0; j < taxableList.length; j++){
                if(taxableList[i].getTax() > taxableList[j].getTax()){
                    Taxable temp = taxableList[i];
                    taxableList[i] = taxableList[j];
                    taxableList[j] = temp;
                }
            }
        }
        return this.taxableList;
    }
}
