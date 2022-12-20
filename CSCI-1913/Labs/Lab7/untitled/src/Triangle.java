import java.lang.Math;
// Authors: Zheng Robert Jia
//          Daniyal Khan

/**
 * A class to represent a triangle in 3d space.
 * You will be filling in a few places...
 */
public class Triangle {

    // Leave these lines alone. No part of this assignment requires modifying these lines
    // and modifying them may be treated as a point-loosing bug.
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * Create a new Triangle given three points to define it.
     * Note -- based on where the points are this triangle may be "degenerate" (I.E. have area 0)
     * @param p1Init
     * @param p2Init
     * @param p3Init
     */
    public Triangle(Point p1Init, Point p2Init, Point p3Init)
    {
        this.p1 = p1Init;
        this.p2 = p2Init;
        this.p3 = p3Init;
    }

    /*
     * @return the first point in the triangle
     */
    public Point getP1() {
        return p1;
    }

    /*
     * @return the second point in the triangle
     */
    public Point getP2() {
        return p2;
    }

    /*
     * @return the third point in the triangle
     */
    public Point getP3() {
        return p3;
    }


    /**
     * This makes a string-formatted version of the triange
     * This is useful for testing and debugging. This function
     * is automatically called by print
     */
    @Override
    public String toString() {
        return "Triangle{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                '}';
    }

    /**
     * Tests if two triangles are equal.
     * @param o - the other triangle. Can actually be anything, but if you give it a not-triang
     *          it's just going to crash so don't do that
     * @return true if-and-only-if two triangles are equal point-by-point. Note this is a little over-fussy since
     *         in geometric princial (0,0)--(2,0)--(2,0) and (2,0)--(0,0)--(0,2) are the same triangle, but would
     *         be seen as inequal to this algorithm. This isn't inherently unfixable, but it's not worth fixing
     *         today. This just means we'll have to be extra careful about triangles.
     */
    @Override
    public boolean equals(Object o) {
        // Note here -- this isn't the code style I would normally go for with this function
        // (It's one of Intellij's defaults)
        // This is _correct_ and that's the important part. We'll see my recommended code style later.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!p1.equals(triangle.p1)) return false;
        if (!p2.equals(triangle.p2)) return false;
        return p3.equals(triangle.p3);
    }


    /**
     * Calculate the area of a triangle using some wierd formula
     * @return double area
     */
    public double getArea() {
        double t1, t2, t3, area;
        t1 = p1.getX() * (p2.getY() - p3.getY());
        t2 = p2.getX() * (p3.getY() - p1.getY());
        t3 = p3.getX() * (p1.getY() - p2.getY()) ;
        area = 0.5*Math.abs(t1+t2+t3);
        return area;
    }

    /**
     * static method for calculating area
     * @param t
     * @return double. area
     */
    public static double getArea(Triangle t) {
        double t1, t2, t3, area;
        t1 = t.p1.getX() * (t.p2.getY() - t.p3.getY());
        t2 = t.p2.getX() * (t.p3.getY() - t.p1.getY());
        t3 = t.p3.getX() * (t.p1.getY() - t.p2.getY()) ;
        area = 0.5*Math.abs(t1+t2+t3);
        return area;
    }
}
