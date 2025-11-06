package at.htlpinkafeld;

import java.util.Arrays;

public class Average implements Calculation{

    private double[] array;

    public Average(double[] array){
        this.array = array.clone();
    }

    public Average(Average av){
        this.array = av.array.clone();
    }

    @Override
    public String toString() {
        return "Average{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public double calculate() {

        double sum = 0;
        for(int i = 0; i < this.array.length; i++){
            sum += this.array[i];
        }
        return sum/this.array.length;
    }
}
