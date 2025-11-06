
package at.htlpinkafeld.pm;
import java.util.Scanner;

public class PersonUI{
	
	private Person[] personList = new Person[5];
	
	public PersonUI(){};
	
	public static void main(String args[]){
		
		PersonUI pUI = new PersonUI();
		
		for(int i = 0; i < 5; i++)
		{
			pUI.personList[i] = pUI.readNewPerson();
		}
		
		for(int i = 0; i < 5; i++)
		{
			System.out.println(pUI.personList[i]);
		}
	}
	
	public Person readNewPerson(){
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Bitte Alter eingeben: ");
			int age = scanner.nextInt();
			System.out.println("Bitte Name eingeben: ");
			String name = scanner.next();
			
			Person p = new Person(age,name);
			return p;
	}
}