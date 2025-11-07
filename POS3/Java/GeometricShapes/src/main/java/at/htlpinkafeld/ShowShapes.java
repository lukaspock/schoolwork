package at.htlpinkafeld;

import java.awt.*;
import java.awt.event.ActionListener;

public class ShowShapes implements MenuItem{
    private Shape2DList list;

    ShowShapes(Shape2DList list){
        this.list = list;
    }

    public String getText(){
        return "Show Shapes: S";
    }
    public void execute(){
        System.out.println("Showing Shapes:");
        for(int i = 0; i < this.list.getLength(); i++)
        {
            System.out.println(i + ". Shape: ");
            this.list.list[i].toString();
        }

    }

    public char getShortcut(){
        return 'S';
    }



}
