package at.htlpinkafeld.utils;

public class Date {
		
	private int day;
	private int month;
	private int year;
	
	public Date(int d, int m, int y)
	{
		this.setDate(d,m,y);
	}
	
	public Date()
	{
		this.day = 1;
		this.month = 1;
		this.year = 2000;
	}

	public Date(Date other){
		this.day = other.day;
		this.month = other.month;
		this.year = other.year;
	}

	public boolean equals(Object obj){
		if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        if(this == obj){
            return true;
        }
        final Date other = (Date) obj;
        return this.day == other.day && this.month == obj.month && this.year == other.year;
    }

	public int hashCode() {
		int result = 17;
		result = 31 * result + this.day;
		result = 32 * result + this.month;
		result = 33 * result + this.year;
		return result;
	}
	
	public void setDate(int d,int m, int y)
	{
		if(checkDate(d,m,y))
		{
			this.day = d;
			this.month = m;
			this.year = y;
		}
		else{
			this.day = 1;
			this.month = 1;
			this.year = 2000;
		}
	}
	
	public int getDay(){return this.day;}
	public int getMonth(){return this.month;}
	public int getYear(){return this.year;}
	
	public String toString(int type)
	{
		String[] monthNamesShort = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		String[] monthNamesLong = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

		switch(type)
		{
			case 1: return ("" + this.day + "." + this.month + "." + this.year);
					
			case 2: return ("" + this.day + "." + monthNamesShort[this.month - 1] + "." + this.year);
					
			case 3: return ("" + this.day + "." + monthNamesLong[this.month - 1] + "." + this.year);
			
			default: return "Invalid Parameter for toString";
		}
	}
	
	public String toString()
	{
		return ("" + this.day + "." + this.month + "." + this.year);
	}
	
	public void diff(int d){
		
		int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if (isLeapYear(this.year)) {
			daysPerMonth[1] = 29;
		}

		
		while (d > 0) {
			if (this.day - d < 1) {
				d -= this.day;
				if (this.month == 1) {
					this.month = 12;
					this.year--;
				} else {
					this.month--;
				}
				this.day = daysPerMonth[this.month - 1];

				if (this.month == 2 && isLeapYear(this.year)) {
					this.day = 29;
				}
			} else {
				this.day -= d;
				break;
				}
			}
		}
	
	public void add(int d) {
		int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		if (isLeapYear(this.year)) {
			daysPerMonth[1] = 29;
		}

		while (d > 0) {
			int daysInCurrentMonth = daysPerMonth[this.month - 1];

			if (this.day + d > daysInCurrentMonth) {
				d -= (daysInCurrentMonth - this.day + 1);
				this.day = 1;
				
				if (this.month == 12) {
					this.month = 1;
					this.year++;
				} else {
					this.month++;
				}
			} else {
				this.day += d;
				break;
			}
		}
	}
	
	private static boolean checkDate(int d, int m, int y)
	{
		int[] validDates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] validLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
		if(m < 0 || m > 12)
			return false;
		
		if(y < 0 || y > 3000)
			return false;
		
		if(isLeapYear(y))
		{
			for(int i = 0; i < 12; i++)
			{
				if(d < 0 || d > validLeap[i])
				{
					return false;
				}
			}
		}
		else{
			for(int i = 0; i < 12; i++)
			{
				if(d < 0 || d > validDates[i])
				{
					return false;
				}
			}
		}
		
		return true;	//is a valid date
	}
	
	public boolean isLeapYear()
	{
		return this.isLeapYear(this.year);
	}

	private static boolean isLeapYear(int y)
	{
		return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
	}
}


	