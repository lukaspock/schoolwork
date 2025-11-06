package at.htlpinkafeld;

public class Volume implements Calculation {

    double width;
    double length;
    double height;

    public Volume(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Volume{" +
                "width=" + width +
                ", length=" + length +
                ", height=" + height +
                '}';
    }

    public Volume(Volume v){
        this.width = v.width;
        this.length = v.length;
        this.height = v.height;
    }

    @Override
    public double calculate() {
        return width*length*height;
    }
}
