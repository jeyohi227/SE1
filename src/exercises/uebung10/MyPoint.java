package exercises.uebung10;

public class MyPoint {

    // Instanzvariablen
    private double x;
    private double y;

    // Konstruktoren
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Instanzvariablen

    public boolean equals(MyPoint p) {
        if( Math.abs(this.x - p.x) < 0.0001 && Math.abs(this.y - p.y) < 0.0001 ) {
            return true;
        }
        return false;
    }

    /*
     * Berechnet die Distanz zwischen zwei Punkten
     * @ return: Distanz ( double )
     */
    public double distanceTo(MyPoint point) {
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
