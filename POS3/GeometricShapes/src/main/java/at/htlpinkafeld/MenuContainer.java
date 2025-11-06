package at.htlpinkafeld;

import java.awt.*;

public class MenuContainer {
    MenuItem[] list;

    MenuContainer(){
        this.list = new MenuItem[0];
    }

    public void addMenuItem(MenuItem menuItem){
        MenuItem[] temp =  new MenuItem[this.list.length+1];

        for(int i=0;i<this.list.length;i++){
            temp[i] = this.list[i];
        }
        temp[temp.length-1] = menuItem;
    }

    public void showMenu(){
        for(int i=0;i<this.list.length;i++){
            this.list[i].getText();
        }
    }

    public void executeMenuItem(char shortcut){
            for(int i=0;i<this.list.length;i++){
                if(this.list[i].getShortcut() == shortcut){
                    this.list[i].execute();
                }
            }
    }

}
