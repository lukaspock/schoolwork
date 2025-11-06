package at.htlpinkafeld;

public class Accumolator implements Action {
    private int total = 0;

    @Override
    public void process(Object obj){
        this.total += (Integer)obj;
    }

    public int getTotal(){
        return total;
    }
}
