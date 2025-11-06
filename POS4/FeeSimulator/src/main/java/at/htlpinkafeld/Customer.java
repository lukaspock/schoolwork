package at.htlpinkafeld;

public class Customer {
    String name;
    int usedMinutes;

    public Customer(String name, int usedMinutes) {
        this.name = name;
        this.usedMinutes = usedMinutes;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getUsedMinutes() {
        return usedMinutes;
    }
    public void setUsedMinutes(int usedMinutes) {
        this.usedMinutes = usedMinutes;
    }

    @Override
    public String toString() {
        return  "name=" + name + ", usedMinutes=" + usedMinutes ;
    }
}
