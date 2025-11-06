package at.htlpinkafeld;

import java.util.Comparator;

public class Main{

    public static long calcArea(Size sz) {
        return (long) sz.getLength() * sz.getWidth();
    }

    public static void main(String[] args) {
        Size[] ar = new Size[3];
        ar[0] = new Car("Audi", 2010, 200, 4235, 1820, 1650);
        ar[1] = new SoccerField();
        ar[2] = new SheetOfPaper(1);

        for(int i = 0; i < ar.length; i++){
            System.out.println("Total Area of " + i+ ". Element: " + calcArea(ar[i]));
        }
    }
}
