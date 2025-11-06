
package at.htlpinkafeld.pm;

public class Person{
	private int age;
	private String name;
	
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public int getAge(){return this.age;}
	public String getName(){return this.name;}
	
	public void setAge(int age){this.age = age;}
	public void setName(String name){this.name = name;}
	
	public String toString(){
		return "Age: " + this.age + " Name: " + this.name;
	}
}
	
	