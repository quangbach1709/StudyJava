package Lap7;


public class Cylinder extends Circle {

    private double heght = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, double heght) {
        super(radius);
        this.heght = heght;
    }

    public double getHeght() {
        return heght;
    }

    public double getVolume() { // tinh the tich
        return super.getArea() * heght;
    }
}
