package exercises.uebung10;

public class BoundingBoxFactory {

    public static MyPrettyRectangle boundingBox(MyPrettyRectangle[] rectangle) {
        double minX = rectangle[0].getX1();
        double minY = rectangle[0].getY1();
        double maxX = rectangle[0].getX2();
        double maxY = rectangle[0].getY2();

        for(int i = 0; i < rectangle.length; i++) {
            if(rectangle[i].getX1() > maxX){
                maxX = rectangle[i].getX1();
            }
            if(rectangle[i].getX2() > maxX){
                maxX = rectangle[i].getX2();
            }
            if(rectangle[i].getY1() > maxY){
                maxY = rectangle[i].getY1();
            }
            if(rectangle[i].getY2() > maxY){
                maxY = rectangle[i].getY2();
            }
            if(rectangle[i].getX1() < minX){
                minX = rectangle[i].getX1();
            }
            if(rectangle[i].getX2() < minX){
                minX = rectangle[i].getX2();
            }
            if(rectangle[i].getY1() < minY){
                minY = rectangle[i].getY1();
            }
            if(rectangle[i].getY2() < minY){
                minY = rectangle[i].getY2();
            }
        }
        MyPrettyRectangle boundingbox = new MyPrettyRectangle(minX, minY, maxX, maxY);

        return boundingbox;
    }
}
