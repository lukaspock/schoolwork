package at.htlpinkafeld.Employee;

public class OfficeWorker extends Employee{
    private double salary;
    private double bonus;

    public OfficeWorker(double salary, double bonus, int empNo, String name) {
        super(empNo, name);
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    public double getWage(){
        return this.salary + this.bonus;
    }
}
