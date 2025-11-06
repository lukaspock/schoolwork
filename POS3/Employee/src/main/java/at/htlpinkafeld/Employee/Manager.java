package at.htlpinkafeld.Employee;

public class Manager extends OfficeWorker{
    private double share;
    private double overtimeSum;
    private double provision;

    public Manager(double salary, double bonus, int empNo, String name, double share, double overtimeSum, double provision){
        super(salary, bonus, empNo, name);
        this.share = share;
        this.overtimeSum = overtimeSum;
        this.provision = provision;
    }

    @Override
    public double getWage(){
        return super.getWage() + this.share + this.overtimeSum + this.provision;
    }
}
