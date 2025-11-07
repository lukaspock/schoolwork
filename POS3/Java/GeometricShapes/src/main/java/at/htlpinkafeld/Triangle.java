package at.htlpinkafeld;

import java.awt.*;
import java.util.regex.Matcher;

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }


    @Override
    public double getArea(){
        double s = (this.sideA + this.sideB + this.sideC) / 2;
        return Math.sqrt(s * (s - this.sideA) * (s - this.sideB) * (s - this.sideC));
    }

    @Override
    public String toString() {
        return "Triangle, area=" + this.getArea() + ", Parameters: sideA=" + this.sideA + ", sideB=" + this.sideB + ", sideC=" + this.sideC;
    }
}

