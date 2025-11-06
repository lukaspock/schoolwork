package at.htlpinkafeld.pm;

public class PersonList{
	private Person[] list = new Person[0];
	
	public PersonList(){};
	
	public void add(Person p){
		this.list.push(p);
	}
	
	public void insert(Person p){
		
	}
	
	public void delete(int idx){
	
	}
	
	public Person getAt(int idx){
		return this.list[idx];
	}
	
	public void SortByName(){
		
	}
	
	public void SortByAge(){
		
	}