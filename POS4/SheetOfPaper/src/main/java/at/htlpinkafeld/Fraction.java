
package at.htlpinkafeld;

public class Fraction implements Comparable{
	private int num;
	private int denom;
	
	public Fraction(int num, int denom){
		if(this.setFraction(num,denom) == false) {
			this.num = 0;
			this.denom = 1;
		}
	}
	
	public boolean setFraction(int num, int denom){
		boolean retVal = false;
		if(denom == 0){
			System.out.println("Invalid denominator. Canceled");
		} else {
			this.num = num;
			this.denom = denom;
			this.checkSign();
			retVal = true;
		}
		return retVal;
	}
	
	public int getNum() { return this.num; }
	
	public int getDenom() { return this.denom; }
	
	public void showFraction() {
	System.out.println("(" + this.num + "/" + this.denom + ")");
	}
	
	public String toString() {
		return "(" + this.num + "/" + this.denom + ")";
	}
	
	public Fraction multFraction(Fraction f){
		Fraction retVal = new Fraction(this.num * f.num, this.denom * f.denom);
		return retVal;
	}
	
	public Fraction divFraction(Fraction f){
		Fraction retVal = new Fraction(this.num * f.num, this.denom * f.denom);
		return retVal;
	}
	
	public Fraction addFraction(Fraction f){
		int newNum = this.num * this.denom + f.num * f.denom;
		int newDenom = this.denom * f.denom;
		Fraction result = new Fraction(newNum,newDenom);
		result.reduce();
		return result;
	}
	
	public Fraction subFraction(Fraction f){
		int newNum = this.num * this.denom + f.num * f.denom;
		int newDenom = this.denom * f.denom;
		Fraction result = new Fraction(newNum,newDenom);
		result.reduce();
		return result;
	}
	
	public void addAndAssignFraction(Fraction fraction) {
		this.setFraction(this.num * fraction.denom + fraction.num * this.denom, this.denom * fraction.denom);
		this.reduce();
	}

	
	private void checkSign () {
		if (this.denom < 0) {
		this.num = -(this. num) ;
		this.denom = -(this.denom);
		}
	}

	private void reduce () {
		int gcd;
		if (this.num < 0)
			gcd = Fraction.calcGCD(-(this.num), this.denom);
		else
			gcd = Fraction. calcGCD (this.num, this.denom) ;
		if (gcd != 1) {
			this.num /= gcd;
			this.denom /= gcd;
		}

	}


	private static int calcGCD(int vall, int val2) {
		int retVal = 1;
		if ( vall == val2 ) {
			retVal = vall;
		} else if ( vall != 0 ) {
			if (vall > val2)
				retVal = Fraction.calcGCD(vall - val2, val2);
			else
				retVal = Fraction.calcGCD(val2 - vall, vall);
		}
		return retVal;
}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Fraction) {
			Fraction f = (Fraction) o;
			if(f.num == this.num && f.denom == this.denom) {
				return 0;
			}
			int num1 = this.num * f.denom;
			int num2 = f.num * this.denom;

			if(num1 < num2){
				return -1;
			}
			else return 1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Fraction)) return false;
		Fraction f = (Fraction) o;
		return this.num == f.num && this.denom == f.denom;
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(num, denom);
	}
}


	