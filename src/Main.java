import Lap4.MyCircle;
import Lap4.MyPoint;
import Lap4.MyTriangle;
import Lap5.MyComplex;
import Lap7.Cylinder;


public class Main {
    public static void main(String[] args) {
//        MyPoint p1 = new MyPoint(3, 0);
//        MyPoint p2 = new MyPoint(0, 4);
//        System.out.println(p1.distance(p2)); // in ra khoang cach giua 2 diem
//        System.out.println(p1.distance(5, 6));// in ra khoang cach giua 2 diem

//        MyCircle c1 = new MyCircle(3, 0, 5);
//        System.out.println(c1.getArea());
//        System.out.println(c1.toString());

//        MyTriangle t1 = new MyTriangle(0, 0, 3, 0, 0, 4);
//        System.out.println(t1.getPerimeter());
//        System.out.println(t1.toString());

//        MyComplex c1 = new MyComplex(3, 4);
//        MyComplex c2 = new MyComplex(3, 4);
//        System.out.println(c1.equals(c2)); //so sanh 2 so phuc
//        System.out.println(c1.magnitude()); //tinh do lon cua so phuc
//        System.out.println(c1.argumentInDegrees() + " degrees"); //tinh goc cua so phuc
//
//        System.out.println(c1.toString());
//        System.out.println(c1.isReal());
//        //tinh tong hieu tich thuong 2 so phuc
//        System.out.println(c1.add(c2));
//        System.out.println(c1.subtract(c2));
//        System.out.println(c1.multiply(c2));
//        System.out.println(c1.divide(c2));

        Cylinder c1 = new Cylinder(3, 4);
        System.out.println(c1.getVolume());


    }
}