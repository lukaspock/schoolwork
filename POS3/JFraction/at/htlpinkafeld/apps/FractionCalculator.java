package at.htlpinkafeld.apps;

import at.htlpinkafeld.fraction.Fraction;
import java.util.Scanner;

public class FractionCalculator {
	
	public static void main(String[] args){
		System.out.println("====== FractionCalculator ======");

		Scanner scanner = new Scanner(System.in);
		int num1, denom1, num2, denom2;
		char opp;
		char abfrage = 'y';
		
		do {
			System.out.println("Fraction1");
			System.out.print("Numerator: ");
			num1 = scanner.nextInt();
			System.out.print("Denominator: ");
			denom1 = scanner.nextInt();
			
			System.out.println("Fraction2");
			System.out.print("Numerator: ");
			num2 = scanner.nextInt();
			System.out.print("Denominator: ");
			denom2 = scanner.nextInt();
			
			System.out.print("Operator (+,-,*,/): ");
			opp = scanner.next().charAt(0);
			
			Fraction f1 = new Fraction(num1, denom1);
			Fraction f2 = new Fraction(num2, denom2);
			Fraction f3 = new Fraction(1, 1);
			
			switch (opp) {
				case '+': 	f3 = f1.addFraction(f2); break;
				case '*': 	f3 = f1.multFraction(f2); break;
				case '/': 	f3 = f1.divFraction(f2); break;
				case '-': 	f3 = f1.subFraction(f2); break;
				default: 	System.out.println("Invalid operator!"); continue;
			}
			
			System.out.println(f1 + " " + opp + " " + f2 + " = " + f3);
			
			System.out.println("Continue? (y/n): ");
			abfrage = scanner.next().charAt(0);
			
		} while (abfrage == 'y');
	}
}
