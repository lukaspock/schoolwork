package at.htlpinkafeld.INTMemory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class INTMemory {
    private int value;
    public static void main(String[] args) {

    }
    INTMemory(){
        this.value = 0;
    }

    INTMemory(int value){
        this.value = value;
    }

    public int getValue(){return value;}

    public void setValue(int value){this.value = value;}

    public void addValue(int value){
        this.value += value;
    }

    public INTMemory join(INTMemory intMemory){
        return new INTMemory(this.value + intMemory.value);
    }


}