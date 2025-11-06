package at.htlpinkafeld.DoubleMethod;
import at.htlpinkafeld.Extension.*;

public class LookUpTable {
    public static void printTable(DoubleMethod meth, double from, double to, double stepSize) {
        System.out.println();
        System.out.println("Lookup table for " + meth.getClass().getSimpleName()
                + ':');
        System.out.println("         X |          Y");
        System.out.println("------------------------");

        for (double x = from; x <= to; x += stepSize) {
            double y = meth.compute(x);
            System.out.println(String.format("%10.2f | %10.2f ", x, y));
        }
    }

    public static void print2DTable(DoubleMethod2D meth, int from, int to) {
        System.out.println();
        System.out.println("Lookup table for " + meth.getClass().getSimpleName() + ":");

        // Header row (Y values)
        System.out.printf("%10s |", "X");
        for (int y = from; y <= to; y++) {
            System.out.printf("%10d", y);
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        // Table body
        for (int x = from; x <= to; x++) {
            System.out.printf("%10d |", x);  // row header
            for (int y = from; y <= to; y++) {
                double value = meth.compute(x, y);
                System.out.printf("%10.0f", value);
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        //Multiply by 2 from 1 to 5, step size 1
        printTable(new TwoTimes(), 1, 5, 1);
        printTable(new Exponential(5), 0,1,0.2); //Exponential function from 0 to 1, step size 0.2
        printTable(new Exponential(2),10,100,10); //Square from 10 to 100, step size 10
        printTable(new Root(),1,10,1 ); //Take the root from 1 to 10, step size 1

        print2DTable(new Add(),1,10);
        print2DTable(new Multiply(),1,10);
        print2DTable(new Pow(),1,5);
    }
}
