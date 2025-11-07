package at.htlpinkafeld.apps;

import at.htlpinkafeld.utils.Date;
import java.util.Scanner;

public class CheckDate
{
		public static void main(String[] args)
		{
			System.out.println("====== CheckDate ======");
			
			Scanner scanner = new Scanner(System.in);
			int day1, month1, year1;
			int day2, month2, year2;
			
			System.out.println("Datum1: ");
			System.out.print("Day: ");
			day1 = scanner.nextInt();
			System.out.print("Month: ");
			month1 = scanner.nextInt();
			System.out.print("Year: ");
			year1 = scanner.nextInt();
			
			Date date1 = new Date(day1,month1,year1);
			
			System.out.println("Datum1: ");
			System.out.print("Day: ");
			day2 = scanner.nextInt();
			System.out.print("Month: ");
			month2 = scanner.nextInt();
			System.out.print("Year: ");
			year2 = scanner.nextInt();
			
			Date date2 = new Date(day2,month2,year2);
			
			System.out.println("Der " + date1.toString(3) + (date1.isLeapYear()? "liegt in einem Schaltjahr": "liegt in keinem Schaltjahr"));
			System.out.println("Der " + date2.toString(3) + (date2.isLeapYear()? "liegt in einem Schaltjahr": "liegt in keinem Schaltjahr"));
			
		}
}