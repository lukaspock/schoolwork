
package at.htlpinkafeld.pm;

public class OlderPerson{
		Person[] pList;
		
		public static void main(String args[])
		{
			OlderPerson oP = new OlderPerson();
			oP.pList = new Person[(args.length/2)];
			int j = 0;
			
			for(int i = 0; i < args.length; i = i + 2)
			{
				oP.pList[j] = new Person(args[i],Integer.parseInt(args[i+1]));
				j++;
			}
			
			System.out.println("ALL: ");
			oP.showAll();
			
			System.out.println("OLDER: ");
			
			oP.showOlder();
			
			
			
		}
		
		public void showAll(){
			for(Person element : this.pList)
			{
				System.out.println(element.toString());
			}
		}
		
		public void showOlder(){
			int avg = this.avgAge();
			for(Person element : this.pList)
			{
				if(element.age() > avg)
				{
					System.out.println(element.toString());
				}
			}
		}
		
		
		public int avgAge(){
			int avg = 0;
			for(int i = 0; i < this.pList.length; i++){
				avg += this.pList[i].age();
			}	
			return avg / this.pList.length;
		}
}


