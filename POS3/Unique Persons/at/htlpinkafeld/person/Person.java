package at.htlpinkafeld.person;
import at.htlpinkafeld.utils.Date;

public class Person{
    private int id;
    private String name;
    private Date birthday;

    public Person(int id, String n, int d, int m, int y){
        this.id = id;
        this.name = n;
        this.birthday = new Date(d,m,y);
    }

    public Person(int id, String n){
        this(id,n,LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(),LocalDate.now().getYear());
    }

    public Person(int id){
        this(id,"N.N",LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(),LocalDate.now().getYear());
    }

    public Person(){
        this(0,"N.N",LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(),LocalDate.now().getYear());
    }

    public Person(Person other){
        this.id = other.id;
        this.name = other.name;
        this.birthday = new Date(other.birthday);
    }

    public boolean equals(Object obj){
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        if(this == obj){
            return true;
        }
        final Person other = (Person) obj;
        return this.id == other.id && this.name.equals(other.name) && this.birthday.equals(other.birthday);
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id;
        result = 34 * result + String.hashCode(this.name);
        result = 35 * result + Date.hashCode(this.birthday);
        return result;
    }


    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', birthday=" + birthday + "}";
    }


}