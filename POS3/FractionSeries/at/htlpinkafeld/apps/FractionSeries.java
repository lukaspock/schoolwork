

package at.htlpinkafeld.apps;
import at.htlpinkafeld.fraction.Fraction;
import java.util.Scanner;

public class FractionSeries{
	
	public static void main(String[] args){
		/*
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How Many terms? ");
		int noe = scanner.nextInt();
		Fraction[] arr = new Fraction[noe];
		
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] =  new Fraction(1,i+1);
		}
		
		int help = noe;
		for(Fraction ele : arr)
		{
			System.out.print(ele);
			if(--help != 0)
			{
				System.out.print(" + ");
			}else{
				System.out.print(" = ");
			}
		}
		
		Fraction sum = new Fraction(0,1);
		
		for(Fraction ele : arr)
		{
			sum.addAndAssignFraction(ele);
		}
		System.out.print(sum);
	}
	*/
	Scanner scanner = new Scanner(System.in);
	System.out.println("How Many terms? ");
		int noe = scanner.nextInt();
		Fraction[] arr = new Fraction[noe];
		
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] =  new Fraction(1,i+1);
		}
		
		int help = noe;
		for(Fraction ele : arr)
		{
			System.out.print(ele);
			if(--help != 0)
			{
				System.out.print(args[0]);
			}else{
				System.out.print(" = ");
			}
		}
		//Fraction sum = new Fraction(0,1);
		Fraction retValue = switch(args[0])
		{
			case "+" -> {
				Fraction sum = new Fraction(0,1);
					for(Fraction ele : arr)
						{
							sum.addAndAssignFraction(ele);
						}
					yield sum;
			}
			case "-" -> {
				Fraction sum = new Fraction(0,1);
					for(Fraction ele : arr)
						{
							sum = sum.subFraction(ele);
						}
					yield sum;
			}
			case "x" -> {
				Fraction sum = new Fraction(0,1);
					for(Fraction ele : arr)
							{
								sum = sum.multFraction(ele);
							}
						yield sum;
			}
			case "/" -> {
				Fraction sum = new Fraction(0,1);
					for(Fraction ele : arr)
							{
								sum = sum.divFraction(ele);
							}
						yield sum;
			}
			default -> {
					Fraction sum = new Fraction(0,1);
					System.out.println("ERROR");
					yield sum;
			}
			
		};
		System.out.print(retValue);
	
	}
}