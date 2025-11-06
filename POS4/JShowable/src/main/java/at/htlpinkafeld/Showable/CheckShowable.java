package at.htlpinkafeld.Showable;
import at.htlpinkafeld.*;


public class CheckShowable {

    public static void main(String[] args) {
        Showable s = new SheetOfPaper(3);
        showObject(s);
        showObject(new Car("Audi", 2010, 200, 4235, 1820, 1650));
        showObject(new SoccerField());
    }

    private static void showObject(Showable s) {
        System.out.print("Show simple: ");
        s.showSimple();
        System.out.print("Show:        ");
        s.show();
        System.out.print("Show all:    ");
        s.showFull();
        System.out.println();
    }
}
