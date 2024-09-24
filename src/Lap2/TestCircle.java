package Lap2;

public class TestCircle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Circle c1 = new Circle();
        System.out.println("Circle 1: " + c1.getRadius() + " and area of " + c1.getArea());


        Circle c2 = new Circle(2.0);
        System.out.println("Circle 2: " + c2.getRadius() + " and area of " + c2.getArea());


        Circle c3 = new Circle(3.0, "blue");
        System.out.println("Circle 3: " + c3.getRadius() + " and area of " + c3.getArea());


        c1.setRadius(5.0);
        c1.setColor("green");
        System.out.println("Circle 1 after modification: " + c1.toString());


        System.out.println("Explicit call to toString(): " + c2.toString());

        System.out.println("Implicit call to toString() via println(): " + c2);


        System.out.println("Operator '+' invokes toString() too: " + c2);

    }

}
