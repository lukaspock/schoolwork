package at.htlpinkafeld;

public class Worker implements Taxable{
    private String name;
    private double monthlyWorkingHours;

    public Worker(String name, double monthlyWorkingHours){
        this.name = name;
        this.monthlyWorkingHours = monthlyWorkingHours;
    }

    @Override
    public double getTax(){
        return this.monthlyWorkingHours * 5;
    }

}
