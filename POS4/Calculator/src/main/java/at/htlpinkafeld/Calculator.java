package at.htlpinkafeld;

public class Calculator {
    private Operator calc;

    public Calculator(Operator calc) {
        this.calc = calc;
    }

    public Operator getCalc() {
        return calc;
    }

    public void setCalc(Operator calc) {
        this.calc = calc;
    }

    public double calculate(double a, double b) {
        return this.calc.calculate(a, b);
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator(new Addition());
        System.out.println(calc.calculate(1.0, 2.0));   //Addition

        calc.setCalc(new Subtraction());
        System.out.println(calc.calculate(1.0, 2.0));   //Subtraction

        calc.setCalc(new Multiplication());
        System.out.println(calc.calculate(5.0, 5.0));   //Multiplication

        calc.setCalc(new Division());
        System.out.println(calc.calculate(5.0, 5.0));   //Division

        calc.setCalc((a,b)-> a * b);
        System.out.println(calc.calculate(5.0, 5.0));   //Freaky Lambda
    }
}
