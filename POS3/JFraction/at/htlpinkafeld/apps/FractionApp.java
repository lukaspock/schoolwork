
package at.htlpinkafeld.apps;
import at.htlpinkafeld.fraction.Fraction; 

public class FractionApp {
    public static void main(String[] args) {
        testFractionAdd();
        //test addAndAssignFraction
    }
    public static void testFractionAdd() {
        System.out.println("====== testFractionAdd ======");
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,2);
        Fraction f3 = f1.addFraction(f2);
        System.out.println("Expected: (1/1)");
        System.out.println("Actual:   " + f3);
    }
	
	public static void testFractiongAddAndAssign() {
        System.out.println("====== testFractiongAddAndAssign ======");
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,2);
        f1.addAndAssignFraction(f2);
        System.out.println("Expected: (1/1)");
        System.out.println("Actual:   " + f1);
    }
}