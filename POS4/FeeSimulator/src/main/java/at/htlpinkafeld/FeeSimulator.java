package at.htlpinkafeld;


public class FeeSimulator {
    Customer[] customers;
    FeeStrategy feeStrategy;

    public FeeSimulator(Customer[] customers) {
        this.customers = customers;
    }

    public double getTotalFee(){
        double total = 0;
        for(int i = 0; i < customers.length; i++){
            total += this.feeStrategy.getFee(customers[i].getUsedMinutes());
        }
        return total;
    }

    public void printFeeList(){
        for(int i = 0; i < customers.length; i++){
            System.out.println("Customer: " +customers[i] + ", FEE = " + this.feeStrategy.getFee(customers[i].getUsedMinutes()));
        }
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }
    public Customer[] getCustomers() {
        return customers;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy){
        this.feeStrategy = feeStrategy;
    }
    public FeeStrategy getFeeStrategy(){
        return this.feeStrategy;
    }

    public static void main(String[] args) {
        Customer[] customers = new Customer[3];
        customers[0] = new Customer("Pook",1000);
        customers[1] = new Customer("Flad",2000);
        customers[2] = new Customer("Grog",3000);

        FeeSimulator fS = new FeeSimulator(customers);
        fS.setFeeStrategy(new ConsumptionBasedFee(2));
        fS.printFeeList();

        System.out.println("Total Fees: " + fS.getTotalFee());

        fS.setFeeStrategy(new MixedFee(1000,1));
        System.out.println("Total Fees: " + fS.getTotalFee());

        fS.setFeeStrategy(new FlatRate(FlatRate.Modus.COMFORT));
        System.out.println("Total Fees: " + fS.getTotalFee());
    }

}
