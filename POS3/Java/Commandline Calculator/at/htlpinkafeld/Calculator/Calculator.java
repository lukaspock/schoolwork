

package at.htlpinkafeld.Calculator;

public class Calculator{
	
		public static void main(String args[])
		{
			Calculator calc = new Calculator();
			double[] values = new double[100];
			char[] opperators = new char[50];
			int status = 1;
			
			double erg = Double.parseDouble(args[0]);
			
			for(int i = 1; i + 1 < args.length; i = i + 2)
			{
					erg = calc.calculate(erg,Double.parseDouble(args[i+1]),args[i].charAt(0));	
			}
			
			System.out.println("Result = " + erg);
		}
		
		public double calculate(double value1, double value2, char operator)
		{
			return switch(operator){
			case '+'-> value1 + value2;
			case 'x' -> value1 * value2;
			case '/' -> value1 / value2;
			case '-' -> value1 - value2;
			default -> {
				System.out.println("ERROR");
				yield 0.0;
			}
			};
		}
}