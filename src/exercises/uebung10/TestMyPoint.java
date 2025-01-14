package exercises.uebung10;

public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint l1 = new MyPoint(0,1);
        MyPoint l2 = new MyPoint(3,3);

        MyPoint r1 = new MyPoint(1,0);
        MyPoint r2 = new MyPoint(4,4);

        MyPoint m1 = new MyPoint(2,2);
        MyPoint m2 = new MyPoint(3,3);

        // 5 1 . 6 4
        MyPoint s1 = new MyPoint(5,1);
        MyPoint s2 = new MyPoint(6,4);

        System.out.println(l1.distanceTo(l2));
        System.out.println(r1.distanceTo(r2));
        System.out.println(m1.distanceTo(m2));
        System.out.println(s1.distanceTo(s2));


    }
}
