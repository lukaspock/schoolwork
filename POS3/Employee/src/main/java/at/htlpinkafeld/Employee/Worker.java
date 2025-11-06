package at.htlpinkafeld.Employee;

public class Worker extends Employee{
    private double hourlyWage;
    private double workingHours;

    public Worker(double hourlyWage,double workingHours, int empNo, String name){
        super(empNo, name);
        this.hourlyWage = hourlyWage;
        this.workingHours = workingHours;
    }

    @Override
    public double getWage(){
        return this.hourlyWage * this.workingHours;
    }
}
