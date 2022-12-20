import java.util.Arrays;

public class ShapeUtilsTester {
     public static void main(String[] args) {
         System.out.println("Point distance test");
         //Point function tests:
         System.out.println("Test 1");
         Point p1 = new Point(1.0, 1.0);
         Point p2 = new Point(1.0, 0.0);
         double d1 = ShapeUtils.distance(p1, p2);
         System.out.println(d1);                          // 1.0

         System.out.println("Test 2");
         Point p3 = new Point(23.6, -34.5);
         double d2 = ShapeUtils.distance(p1, p3);
         System.out.println(d2);                          //42.083369636948035
//
//
         Triangle triangle;
         Point[] trianglePoints;
         double area;
         Point p;

         System.out.println("Center point test");

         System.out.println("Test 1");
         trianglePoints = new Point[3];
         trianglePoints[0] = new Point(80, 0);
         trianglePoints[1] = new Point(0, 10);
         trianglePoints[2] = new Point(160, 10);

         p = ShapeUtils.getCenter(trianglePoints);
         System.out.println(p); // (80.0, 6.666666666666667)

         System.out.println("Test 2");
         trianglePoints = new Point[3];
         trianglePoints[0] = new Point(12, 10);
         trianglePoints[1] = new Point(0, 53);
         trianglePoints[2] = new Point(30, 54);

         p = ShapeUtils.getCenter(trianglePoints);
         System.out.println(p); // (14.0, 39.0)

         System.out.println("Test 3");
         trianglePoints = new Point[3];
         trianglePoints[0] = new Point(1, 0);
         trianglePoints[1] = new Point(3, 4);
         trianglePoints[2] = new Point(5, 4);

         p = ShapeUtils.getCenter(trianglePoints);
         System.out.println(p); // (3.0, 2.6666666666666665)

         System.out.println("Test 4");
         trianglePoints = new Point[0];
         // empty array: return (0, 0)
         p = ShapeUtils.getCenter(trianglePoints);
         System.out.println(p); // (0.0, 0.0)

         System.out.println("Test 5");
         trianglePoints = new Point[10];
         trianglePoints[0] = new Point(1, 10);
         trianglePoints[1] = new Point(2, 9);
         trianglePoints[2] = new Point(3, 8);
         trianglePoints[3] = new Point(4, 7);
         trianglePoints[4] = new Point(5, 6);
         trianglePoints[5] = new Point(6, 5);
         trianglePoints[6] = new Point(7, 4);
         trianglePoints[7] = new Point(8, 3);
         trianglePoints[8] = new Point(9, 2);
         trianglePoints[9] = new Point(10, 1);

         p = ShapeUtils.getCenter(trianglePoints);
         System.out.println(p); // (5.5, 5.5)


         System.out.println("Fake polygon test");
         Triangle[] fakePoly;
         Point[] trunkPoints = new Point[4];

         System.out.println("Test 1");
         trunkPoints[0] = new Point(0, 0);
         trunkPoints[1] = new Point(0, 30);
         trunkPoints[2] = new Point(80, 30);
         trunkPoints[3] = new Point(80, 0);

         fakePoly = ShapeUtils.makeFakePoly(trunkPoints);
         for (Triangle tri : fakePoly) {
             System.out.println(tri);
         }

         // Triangle{p1=(0.0, 0.0), p2=(0.0, 30.0), p3=(40.0, 15.0)}
         // Triangle{p1=(0.0, 30.0), p2=(80.0, 30.0), p3=(40.0, 15.0)}
         // Triangle{p1=(80.0, 30.0), p2=(80.0, 0.0), p3=(40.0, 15.0)}
         // Triangle{p1=(80.0, 0.0), p2=(0.0, 0.0), p3=(40.0, 15.0)}

         System.out.println("Test 2");
         trunkPoints = new Point[6];
         trunkPoints[0] = new Point(0, 0);
         trunkPoints[1] = new Point(1, 0);
         trunkPoints[2] = new Point(1, 1);
         trunkPoints[3] = new Point(2, 3);
         trunkPoints[4] = new Point(4, 5);
         trunkPoints[5] = new Point(6, 7);

         fakePoly = ShapeUtils.makeFakePoly(trunkPoints);
         for (Triangle tri : fakePoly) {
             System.out.println(tri);
         }

         // Triangle{p1=(0.0, 0.0), p2=(1.0, 0.0), p3=(2.3333333333333335, 2.6666666666666665)}
         // Triangle{p1=(1.0, 0.0), p2=(1.0, 1.0), p3=(2.3333333333333335, 2.6666666666666665)}
         // Triangle{p1=(1.0, 1.0), p2=(2.0, 3.0), p3=(2.3333333333333335, 2.6666666666666665)}
         // Triangle{p1=(2.0, 3.0), p2=(4.0, 5.0), p3=(2.3333333333333335, 2.6666666666666665)}
         // Triangle{p1=(4.0, 5.0), p2=(6.0, 7.0), p3=(2.3333333333333335, 2.6666666666666665)}
         // Triangle{p1=(6.0, 7.0), p2=(0.0, 0.0), p3=(2.3333333333333335, 2.6666666666666665)}

         System.out.println("Test 3");
         Point[] points = new Point[9];
         points[0] = new Point(50.0, 50.0);
         points[1] = new Point(300.0, 50.0);
         points[2] = new Point(300.0, 150.0);
         points[3] = new Point(270.0, 155.0);
         points[4] = new Point(270.0, 200.0);
         points[5] = new Point(250.0, 200.0);
         points[6] = new Point(250.0, 170.0);
         points[7] = new Point(150.0, 300.0); // peak
         points[8] = new Point(50.0, 150.0);

         fakePoly = ShapeUtils.makeFakePoly(points);
         for (Triangle tri : fakePoly) {
             System.out.println(tri);
         }

         // Triangle{p1=(50.0, 50.0), p2=(300.0, 50.0), p3=(210.0, 158.33333333333334)}
         // Triangle{p1=(300.0, 50.0), p2=(300.0, 150.0), p3=(210.0, 158.33333333333334)}
         // Triangle{p1=(300.0, 150.0), p2=(270.0, 155.0), p3=(210.0, 158.33333333333334)}
         // Triangle{p1=(270.0, 155.0), p2=(270.0, 200.0), p3=(210.0, 158.33333333333334)}
         // Triangle{p1=(270.0, 200.0), p2=(250.0, 200.0), p3=(210.0, 158.33333333333334)}
         // Triangle{p1=(250.0, 200.0), p2=(250.0, 170.0), p3=(210.0, 158.33333333333334)}
         // Triangle{p1=(250.0, 170.0), p2=(150.0, 300.0), p3=(210.0, 158.33333333333334)}
         // Triangle{p1=(150.0, 300.0), p2=(50.0, 150.0), p3=(210.0, 158.33333333333334)}
         // Triangle{p1=(50.0, 150.0), p2=(50.0, 50.0), p3=(210.0, 158.33333333333334)}

         System.out.println("Is in triangle tests");

         System.out.println("Test 1");
         trianglePoints = new Point[3];
         trianglePoints[0] = new Point(80, 0);
         trianglePoints[1] = new Point(0, 50);
         trianglePoints[2] = new Point(160, 50);
         triangle = new Triangle(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
         p = new Point(80, 30);
         System.out.println(ShapeUtils.isIn(triangle, p)); // true


         System.out.println("Test 2");
         trianglePoints = new Point[3];
         trianglePoints[0] = new Point(80, 0);
         trianglePoints[1] = new Point(0, 50);
         trianglePoints[2] = new Point(120, 40);
         triangle = new Triangle(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
         p = new Point(80, 130);
         System.out.println(ShapeUtils.isIn(triangle, p)); // false


         System.out.println("Test 3");
         trianglePoints = new Point[3];
         trianglePoints[0] = new Point(80, 0);
         trianglePoints[1] = new Point(0, 50);
         trianglePoints[2] = new Point(120, 50);
         triangle = new Triangle(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
         p = new Point(80, 0);
         System.out.println(ShapeUtils.isIn(triangle, p)); // true


         System.out.println("Test 4");
         trianglePoints = new Point[3];
         trianglePoints[0] = new Point(10, 0);
         trianglePoints[1] = new Point(0, 0);
         trianglePoints[2] = new Point(0, 10);
         triangle = new Triangle(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
         p = new Point(5, 0);
         System.out.println(ShapeUtils.isIn(triangle, p)); // true
//

         System.out.println("Is in circle tests");

         System.out.println("Test 1");
         Circle c1 = new Circle(new Point(0, -5), 10);
         p = new Point(0, 0);
         System.out.println(ShapeUtils.isIn(c1, p)); // true

         System.out.println("Test 2");
         c1 = new Circle(new Point(0, -5), 1);
         p = new Point(0, 0);
         System.out.println(ShapeUtils.isIn(c1, p)); // false

         System.out.println("Test 3");
         c1 = new Circle(new Point(0, -5), 5);
         p = new Point(0, 0);
         System.out.println(ShapeUtils.isIn(c1, p)); // true
//
//
//         Circle c2;
//
//         System.out.println("IsThereOverlap tests");
//
//         System.out.println("Test 1");
//         // easy no -- two circles way apart
//         c1 = new Circle(new Point(-10, -10), 0.1);
//         c2 = new Circle(new Point(10, 8.2), 1);
//         System.out.println(ShapeUtils.isThereOverlap(c1,c2)); // false
//
//         System.out.println("Test 2");
//         // easy yes -- it's the same circle twice
//         System.out.println(ShapeUtils.isThereOverlap(c1,c1)); // true
//
//         System.out.println("Test 3");
//         // more interesting no -- close, but not touching
//         c1 = new Circle(new Point(0, 0), 1);
//         c2 = new Circle(new Point(2, 0), 0.99);
//         System.out.println(ShapeUtils.isThereOverlap(c1,c2)); // false
//
//         System.out.println("Test 4");
//         // easy overlapping yes (draw them if you don't believe me!)
//         c1 = new Circle(new Point(0, 0), 1);
//         c2 = new Circle(new Point(1, 1), 1);
//         System.out.println(ShapeUtils.isThereOverlap(c1,c2)); // true
//
//         System.out.println("Test 5");
//         // Interesting case -- they are tangent -- touching at one point
//         // we don't call that overlapping.
//         c1 = new Circle(new Point(0, 0), 1);
//         c2 = new Circle(new Point(0, -2), 1);
//         System.out.println(ShapeUtils.isThereOverlap(c1,c2)); // false
//
//         System.out.println("Test 6");
//         // Another interesting case -- c2 is entirely inside c1!
//         c1 = new Circle(new Point(10, 15), 20);
//         c2 = new Circle(new Point(3.1, 2.4), 3);
//         System.out.println(ShapeUtils.isThereOverlap(c1,c2)); // true
//
//         System.out.println("Triangle area methods test");
//         System.out.println("Test 1");
//         trianglePoints = new Point[3];
//         trianglePoints[0] = new Point(80, 0);
//         trianglePoints[1] = new Point(0, 50);
//         trianglePoints[2] = new Point(160, 50);
//
//         triangle = new Triangle(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
//
//         area = triangle.getArea();
//         System.out.println(area); // 4000.0
//         area = triangle.getArea(triangle);
//         System.out.println(area); // 4000.0
//         area = ShapeUtils.getArea(triangle);
//         System.out.println(area); // 4000.0
//
//         System.out.println("Test 2");
//         trianglePoints = new Point[3];
//         trianglePoints[0] = new Point(12, 10);
//         trianglePoints[1] = new Point(0, 53);
//         trianglePoints[2] = new Point(30, 54);
//
//         triangle = new Triangle(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
//
//         area = triangle.getArea();
//         System.out.println(area); // 651.0
//         area = triangle.getArea(triangle);
//         System.out.println(area); // 651.0
//         area = ShapeUtils.getArea(triangle);
//         System.out.println(area); // 651.0
//
//         System.out.println("Test 3");
//         trianglePoints = new Point[3];
//         trianglePoints[0] = new Point(1, 0);
//         trianglePoints[1] = new Point(3, 4);
//         trianglePoints[2] = new Point(5, 4);
//
//         triangle = new Triangle(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
//
//         area = triangle.getArea();
//         System.out.println(area); // 4.0
//         area = triangle.getArea(triangle);
//         System.out.println(area); // 4.0
//         area = ShapeUtils.getArea(triangle);
//         System.out.println(area); // 4.0
     }
 }

 /*

 Point distance test
Test 1
1.0
Test 2
42.083369636948035
Center point test
Test 1
(80.0, 6.666666666666667)
Test 2
(14.0, 39.0)
Test 3
(3.0, 2.6666666666666665)
Test 4
(0.0, 0.0)
Test 5
(5.5, 5.5)
Fake polygon test
Test 1
Triangle{p1=(0.0, 0.0), p2=(0.0, 30.0), p3=(40.0, 15.0)}
Triangle{p1=(0.0, 30.0), p2=(80.0, 30.0), p3=(40.0, 15.0)}
Triangle{p1=(80.0, 30.0), p2=(80.0, 0.0), p3=(40.0, 15.0)}
Triangle{p1=(80.0, 0.0), p2=(0.0, 0.0), p3=(40.0, 15.0)}
Test 2
Triangle{p1=(0.0, 0.0), p2=(1.0, 0.0), p3=(2.3333333333333335, 2.6666666666666665)}
Triangle{p1=(1.0, 0.0), p2=(1.0, 1.0), p3=(2.3333333333333335, 2.6666666666666665)}
Triangle{p1=(1.0, 1.0), p2=(2.0, 3.0), p3=(2.3333333333333335, 2.6666666666666665)}
Triangle{p1=(2.0, 3.0), p2=(4.0, 5.0), p3=(2.3333333333333335, 2.6666666666666665)}
Triangle{p1=(4.0, 5.0), p2=(6.0, 7.0), p3=(2.3333333333333335, 2.6666666666666665)}
Triangle{p1=(6.0, 7.0), p2=(0.0, 0.0), p3=(2.3333333333333335, 2.6666666666666665)}
Test 3
Triangle{p1=(50.0, 50.0), p2=(300.0, 50.0), p3=(210.0, 158.33333333333334)}
Triangle{p1=(300.0, 50.0), p2=(300.0, 150.0), p3=(210.0, 158.33333333333334)}
Triangle{p1=(300.0, 150.0), p2=(270.0, 155.0), p3=(210.0, 158.33333333333334)}
Triangle{p1=(270.0, 155.0), p2=(270.0, 200.0), p3=(210.0, 158.33333333333334)}
Triangle{p1=(270.0, 200.0), p2=(250.0, 200.0), p3=(210.0, 158.33333333333334)}
Triangle{p1=(250.0, 200.0), p2=(250.0, 170.0), p3=(210.0, 158.33333333333334)}
Triangle{p1=(250.0, 170.0), p2=(150.0, 300.0), p3=(210.0, 158.33333333333334)}
Triangle{p1=(150.0, 300.0), p2=(50.0, 150.0), p3=(210.0, 158.33333333333334)}
Triangle{p1=(50.0, 150.0), p2=(50.0, 50.0), p3=(210.0, 158.33333333333334)}
Is in triangle tests
Test 1
true
Test 2
false
Test 3
true
Test 4
true
Is in circle tests
Test 1
true
Test 2
false
Test 3
true
IsThereOverlap tests
Test 1
false
Test 2
true
Test 3
false
Test 4
true
Test 5
false
Test 6
true
Triangle area methods test
Test 1
4000.0
4000.0
4000.0
Test 2
651.0
651.0
651.0
Test 3
4.0
4.0
4.0


  */