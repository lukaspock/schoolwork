package at.htlpinkafeld;

public class Shape2DList {
    protected Shape[] list;

    Shape2DList(){
        this.list = new Shape[0];
    }

    public void addShape(Shape s){
        Shape[] list = new Shape[this.list.length+1];

        for(int i=0;i<this.list.length;i++){
            list[i]=this.list[i];
        }
        list[list.length-1] = s;
        this.list = list;

    }

    public int getLength(){
        return this.list.length;
    }
}
