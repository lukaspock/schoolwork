package at.htlpinkafeld;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Shape2DList list = new Shape2DList();
        MenuContainer mc = new MenuContainer();

        MenuItem aC = new AddCircle(list);
        MenuItem aR = new AddRectangle(list);
        MenuItem sS = new ShowShapes(list);

        mc.addMenuItem(aC);
        mc.addMenuItem(aR);
        mc.addMenuItem(sS);

        Scanner sc = new Scanner(System.in);
        char choice = 'Y';


        while(choice == 'Y'){
            mc.showMenu();
            mc.executeMenuItem(sc.next().charAt(0));

            System.out.println("Another Run? Y/N");
                choice = sc.next().charAt(0);
        }
    }
}