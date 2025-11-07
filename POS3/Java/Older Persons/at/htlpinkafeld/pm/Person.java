
package at.htlpinkafeld.pm;

public record Person(String name, int age) {
	public Person(String name, int age){
		if(age >= 0 && age <= 120){
			this.name = name;
			this.age = age;
		}
		else{
			this.name = "";
			this.age = 0;
		}
	}
}