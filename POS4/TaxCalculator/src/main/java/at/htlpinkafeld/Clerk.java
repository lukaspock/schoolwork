package at.htlpinkafeld;

import java.util.Objects;

public class Clerk implements Taxable{
    private String name;
    private double totalWorkingYears;

    public Clerk(String name, double totalWorkingYears){
        this.name = name;
        this.totalWorkingYears = totalWorkingYears;
    }

    @Override
    public double getTax(){
        return this.totalWorkingYears * 10;
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "name='" + name + '\'' +
                ", totalWorkingYears=" + totalWorkingYears +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clerk clerk = (Clerk) o;
        return Double.compare(totalWorkingYears, clerk.totalWorkingYears) == 0 && Objects.equals(name, clerk.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalWorkingYears);
    }
}
