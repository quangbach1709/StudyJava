import Lap4.MyCircle;
import Lap4.MyPoint;
import Lap4.MyTriangle;

public class Main {
    public static void main(String[] args) {
//        MyPoint p1 = new MyPoint(3, 0);
//        MyPoint p2 = new MyPoint(0, 4);
//        System.out.println(p1.distance(p2)); // in ra khoang cach giua 2 diem
//        System.out.println(p1.distance(5, 6));// in ra khoang cach giua 2 diem

//        MyCircle c1 = new MyCircle(3, 0, 5);
//        System.out.println(c1.getArea());
//        System.out.println(c1.toString());

        MyTriangle t1 = new MyTriangle(0, 0, 3, 0, 0, 4);
        System.out.println(t1.getPerimeter());
        System.out.println(t1.toString());
        

    }
}