package at.htlpinkafeld.dome;

/**
 * The database class provides a facility to store CD and video objects. A list
 * of all CDs and videos can be printed to the terminal.
 *
 * This version does not save the data to disk, and it does not provide any
 * search functions.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Database{

    private Medium[] list;
    private int anz;


    public Database() {
        list = new Medium[10];
        anz = 0;

    }

    public void add(Medium m) {
        list[anz] = m;
        anz++;
    }

    public void list() {
        for (int i = 0; i < anz; i++) {
            System.out.println(list[i]);
        }
    }

    public int calcTotalPlayingTime(){

        int total = 0;

        for (int i = 0; i < anz; i++) {
            if(this.list[i].gotIt){
                total += this.list[i].getPlayingTime();
            }
        }
        return total;
    }

    public void sortByTitle(){
        for (int i = 0; i < anz; i++) {
            for (int j = 0; j < anz - i - 1; j++) {
                if (this.list[i].compareTo(this.list[j]) > 0) {
                    Medium temp = this.list[i];
                    this.list[i] = this.list[j];
                    this.list[j] = temp;
                }
            }
        }
    }

    public void playAll() {
        for(int i = 0; i < anz; i++){
            this.list[i].play();
        }
    }

    public static void main(String[] args) {
        DVD d;
        CD c;
        VinylRecord v;
        Database db = new Database();

        db.add(new CD("Olle san ma lustig", "Die Bergspatzen", 15, 43));

        c = new CD("Ich hab dich so lieb", "Der Schöne", 9, 20);
        c.setOwn(true);
        c.setComment("Wieso hab ich das gekauft??");
        db.add(c);

        db.add(new DVD("A zombie never dies. XXIII", "Ruben Rubbish", 107));


        v = new VinylRecord(2,3,10,15,2000,"Lukas",true,"super");
        db.add(v);

        db.list();

        db.playAll();
        System.out.println("Total playing time: " + db.calcTotalPlayingTime());

        db.sortByTitle();
        System.out.println("\n\n\nSorted by title");
        db.list();
    }


}
