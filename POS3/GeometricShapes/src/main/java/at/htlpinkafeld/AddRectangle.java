package at.htlpinkafeld;

import java.awt.event.ActionListener;
import java.util.Scanner;

public class AddRectangle implements MenuItem{

    Shape2DList list;

    public AddRectangle(Shape2DList list){
        this.list=list;
    }

    public String getText(){
        return "Add Rectangle: R";
    }
    public void execute(){

            Scanner sc=new Scanner(System.in);
            System.out.println("Adding Circle");
            System.out.println("Radius: ");

            Shape s = new Circle(sc.nextDouble());

            this.list.addShape(s);
        }

    public char getShortcut(){
        return 'R';
    }
}
