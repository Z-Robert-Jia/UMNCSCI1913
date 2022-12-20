
// Authors:
// Zheng Robert Jia
// Daniyal Khan

public class ShapeUtils {
    /**
     * Calculates distance betweeen two point objects
     * @param p1: Point object
     * @param p2: Point object
     * @return distance in double
     */
    public static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2));
    }

    /**
     *
     * @param points
     * @return a Point object representing the center of the given points array
     */
    public static Point getCenter(Point[] points){
        Point Center = new Point(0,0);
        if (points.length<=1){
            return Center;
        }
        double dx=0;
        double dy=0;
        for (int i = 0; i < points.length; i++){
            dx += points[i].getX();
            dy += points[i].getY();
        }
        Center.move(dx/points.length,dy/ points.length);
        return Center;
    }

    /**
     * Assume the points array has length >= 3
     * @param points
     * @return an array of triangles representing the polygon
     */
    public static Triangle[] makeFakePoly(Point[] points){
        Triangle[] triangles = new Triangle[points.length];
        int len = points.length;
        Point center = getCenter(points);
        for (int i = 0; i<points.length; i++){
            triangles[i] = new Triangle(points[i%len],points[(i+1)%len],center);
        }
        return triangles;
    }

    /***
     * @param c
     * @return the double representing the Area of the given Circle c
     */
    public static double getArea(Circle c){
        double area;
        area = Math.PI*Math.pow(c.getRadius(),2);
        return area;
    }
//    public static double getArea(Triangle t){
//
//    }

    /**
     * @param t
     * @param p
     * @return a boolean indicating whether the Point p is inside Triangle t
     */
    public static boolean isIn(Triangle t, Point p){
        // Calculate actual area
        double actualArea = t.getArea();
        // Calculate three subtriangles
        double sum;
        Triangle t1 = new Triangle(t.getP1(),t.getP2(),p);
        Triangle t2 = new Triangle(p,t.getP2(),t.getP3());
        Triangle t3 = new Triangle(t.getP1(),p,t.getP3());
        sum = t1.getArea() + t2.getArea() + t3.getArea();
        // Return abs dif
        return Math.abs(sum-actualArea)<0.00001;
    }

    /**
     * @param c
     * @param p
     * @return true if the Point p is in Circle c
     */
    public static boolean isIn(Circle c, Point p){
        return distance(c.getCenter(),p)<=c.getRadius();
    }

    /**
     * @param c1
     * @param c2
     * @return boolean if the two Circle c1, c2 overlaps
     */
    public static boolean isThereOverlap(Circle c1, Circle c2){
        // Check the distance between two centers
        // Check their radius sum
        double r_sum = c1.getRadius()+c2.getRadius();
        double dis = distance(c1.getCenter(),c2.getCenter());
        return dis<r_sum;
    }

    /**
     * Calculates area of a triangle
     * @param t
     * @return double. area
     */
    public static double getArea(Triangle t){
        double t1, t2, t3, area;
        t1 = t.getP1().getX() * (t.getP2().getY() - t.getP3().getY());
        t2 = t.getP2().getX() * (t.getP3().getY() - t.getP1().getY());
        t3 = t.getP3().getX() * (t.getP1().getY() - t.getP2().getY()) ;
        area = 0.5*Math.abs(t1+t2+t3);
        return area;
    }
}
