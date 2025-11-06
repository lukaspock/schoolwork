
package at.htlpinkafeld.pm;
import at.htlpinkafeld.utils.Date;
import at.htlpinkafeld.person.Person;

public class UniquePersonApp{

    public static void main(String[] args){

        UniquePersonApp app = new UniquePersonApp();
        Person[] allPersons = new Person[100];

        for(int i = 0; i < args.length/5; i = i + 4){
            allPersons[i] = new Person(Integer.parseInt(args[i]),args[i+1],Integer.parseInt(args[i+2]),Integer.parseInt(args[i+3]),Integer.parseInt(args[i+4]));
        }

        Person[] uniquePersons = new Person[100];

        for(int i = 0; i < allPersons.length; i++){
            uniquePersons[i] = new Person(allPersons[i]);
        }
        
        int count;
        for (Person p : allPersons) {
            if (p != null) count++;
        }
        

        for(int i = 0; i < count; i++){
            for(int j = i + 1; j < count; j++){
                if(uniquePersons[i].equals(uniquePersons[j])){
                    for(int x = j; x < count; x++){
                        uniquePersons[x] = uniquePersons[x+1]; // removes the matching person
                    }
                    j = j - 1;
                    count--;
                }
            }
        }
        
        System.out.println("Output all People: ");
        app.showPersonArray(allPersons);
        System.out.println("Output all Unique: ");
        app.showPersonArray(uniquePersons);

    }

    public void showPersonArray(Person[] arr){
        int count;
        for (Person p : arr) {
            if (p != null) count++;
        }
        for(int i = 0; i < count; i++){
            System.out.println(arr[i]);
        }
    }

}