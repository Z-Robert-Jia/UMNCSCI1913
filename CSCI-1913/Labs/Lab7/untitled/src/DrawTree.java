
// Author:
// Zheng Robert Jia
// Daniyal Khan

import java.awt.*;

public class DrawTree {
    public static void main(String[] args) {
        ShapeDrawer myDrawer = new ShapeDrawer(100,100);
        // Defind points to draw the tree, decoration, and trunck, sun
        // Draw tree
        Point[] topTri = new Point[5];
        topTri[0] = new Point(20,60);
        topTri[1] = new Point(80,60);
        topTri[2] = new Point(60,50);
        topTri[3] = new Point(50,40);
        topTri[4] = new Point(40,50);
        myDrawer.setFill(Color.GREEN);
        myDrawer.setStroke(Color.white);
        Triangle[] top = ShapeUtils.makeFakePoly(topTri);
        for (Triangle ele : top){
            myDrawer.draw(ele);
        }
        // Draw trunk
        Point[] trunk_tri = new Point[4];
        trunk_tri[0] = new Point(40,100);
        trunk_tri[1] = new Point(70,100);
        trunk_tri[2] = new Point(60,60);
        trunk_tri[3] = new Point(50,60);
        Triangle[] trunk = ShapeUtils.makeFakePoly(trunk_tri);
        myDrawer.setStroke(Color.darkGray);
        myDrawer.setFill(Color.darkGray);
        for (Triangle ele : trunk){
            myDrawer.draw(ele);
        }
        // Draw Sun
        Circle sun = new Circle(new Point(20,20),10);
        myDrawer.setFill(new Color(191, 71, 50));
        myDrawer.setStroke(Color.black);
        myDrawer.draw(sun);

        // Draw decoration
        Circle d1 = new Circle(new Point(50,40),5);
        myDrawer.setStroke(Color.RED);
        myDrawer.setFill(Color.RED);
        myDrawer.draw(d1);
        myDrawer.writeToFile("tree.png");
    }
}
