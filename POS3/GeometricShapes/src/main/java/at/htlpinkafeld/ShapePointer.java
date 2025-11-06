package at.htlpinkafeld;

public class ShapePointer {

    public void printShapes(Shape[] shapes){
        System.out.println("Number of Shapes: " + shapes.length);

        double totalArea = 0;
        for(Shape shape : shapes){
            totalArea += shape.getArea();
        }

        System.out.println("Total area: " +  totalArea);

        int i = 0;
        for (Shape shape : shapes){
            System.out.println("Shape " + i + ": " + shape);
        }
    }
}
