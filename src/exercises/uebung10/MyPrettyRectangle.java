package exercises.uebung10;

import static java.lang.Math.round;

public class MyPrettyRectangle {

    // Instanzvariablen
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private MyPoint p1; // Punkt(x1, y1)
    private MyPoint p2; // Punkt(x2, y2)
    private MyPoint p3; // Punkt(x1, y2)
    //Kantenlängen
    private double a;
    private double b;


    // Konstruktoren
    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.p1 = new MyPoint(x1, y1);
        this.p2 = new MyPoint(x2, y2);

        MyPoint p3 = new MyPoint(x1, y2);
        this.a = p1.distanceTo(p3);
        this.b = p2.distanceTo(p3);
    }

    // getter Methoden
    public double getX1() {
        return x1;
    }
    public double getY1() {
        return y1;
    }
    public double getX2() {
        return x2;
    }
    public double getY2() {
        return y2;
    }

    // Instanzmethoden
    public boolean contains(MyPrettyRectangle middle) {
        // x1 & y1 <= x1 & y1 von middle
        // x2 & y2 >= x2 & y2 von middle

        if( this.x1 <= middle.x1 && this.y1 <= middle.y1 && this.x2 >= middle.x2 && this.y2 >= middle.y2 )
            return true;

        return false;
    }

    public MyPoint getCenter() {
        double x = (x1 + x2) / 2;
        double y = (y1 + y2) / 2;

        return new MyPoint(x, y);
    }

    public double getArea() {
        return a * b;
    }

    public double getPerimeter() {
        return 2 * ( a + b );
    }

    public static boolean equals(MyPrettyRectangle m1, MyPrettyRectangle m2) {
        if( m1.p1.equals(m2.p1) &&  m1.p2.equals(m2.p2) ){
            return true;
        }
        return false;
    }

    public String toString() {
        return "( " + x1 + ", " + y1 + ", " + x2 + ", " + y2 + " )";
    }
}
