package Lap4;

public class MyCircle {
    private MyPoint center;
    private int radius = 1;


    public MyCircle(int x, int y, int radius) {
        this.center = new MyPoint(x, y);
        this.radius = radius;
    }

    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getCenterX(int x) {
        return center.getX();
    }

    public int getCenterY(int y) {
        return center.getY();
    }

    public void setCenterXY(int x, int y) {
        center.setX(x);
        center.setY(y);
    }

    @Override
    public String toString() {
        return "MyCircle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    public double getArea() { //tinh dien tich hinh tron
        return Math.PI * Math.pow(radius, 2);
    }


}
