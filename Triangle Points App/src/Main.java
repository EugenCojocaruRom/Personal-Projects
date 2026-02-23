public class Main {
    public static void main(String[] args) {

        //Initial test data
        Point p1 = new Point(2, 3);
        System.out.println("Point 1: " + p1);
        System.out.println("Point 1 to some other point: " + p1.distanceTo(new Point(4, 5)));

        //Additional test data
        System.out.println("\n<=== Points ===>");
        Point p2 = new Point(1, -3);
        System.out.println("Point 2: " + p2);
        Point p3 = new Point(4, 5);
        System.out.println("Point 3: " + p3);
        Point p4 = new Point(-2, 6);
        System.out.println("Point 4: " + p4);
        Point p5 = new Point(7, 9);
        System.out.println("Point 5: " + p5);

        System.out.println("\n<=== Distance between points ===>");
        System.out.println("Point 1 to Point 2: " + p1.distanceTo(p2));
        System.out.println("Point 1 to Point 3: " + p1.distanceTo(p3));
        System.out.println("Point 2 to Point 4: " + p2.distanceTo(p4));
        System.out.println("Point 5 to Point 5: " + p5.distanceTo(p5));
        System.out.println("Point 3 to some other point: " + p2.distanceTo(new Point(6, 9)));

        System.out.println("\n<=== Moving points ===>");
        System.out.println("Point 1 current position: " + p1);
        p1.move(5, 8);
        System.out.println("Moved Point 1 by (5, 4).\n\tNew position: " + p1);
        System.out.println("Point 2 current position: " + p2);
        p2.move(-8, 14);
        System.out.println("Moved Point 2 by (-8, 14).\n\tNew position: " + p2);

        System.out.println("\n<=== Triangle check ===>");
        Point x = new Point(1, 2);
        System.out.println("Point 1: " + x);
        Point y = new Point(5, 4);
        System.out.println("Point 2: " + y);
        Point z = new Point(4, 8);
        System.out.println("Point 3: " + z);
        Point t = new Point(-2, 6);
        System.out.println("Point 4: " + t);
        Point u = new Point(3, 4); //same coordinates as Point 8
        System.out.println("Point 5: " + u);
        Point v = new Point(4, 5);
        System.out.println("Point 6: " + v);
        Point w = new Point(7, 9);
        System.out.println("Point 7: " + w);
        Point o = new Point(3, 4); //same coordinates as Point 5
        System.out.println("Point 8: " + o);
        System.out.println("Can points 1, 2 and 3 form a triangle? --> " + Point.canFormTriangle(x, y, z));
        System.out.println("Can points 4, 5 and 6 form a triangle? --> " + Point.canFormTriangle(t, u, v));
        System.out.println("Can points 4, 5 and 8 form a triangle? --> " + Point.canFormTriangle(t, u, o));
        System.out.println("Can points 1, 2 and 3 form a right-angled triangle? --> " +
                Point.canFormRightAngledTriangle(x, y, z));
        System.out.println("Can points 1, 5 and 6 form a right-angled triangle? --> " +
                Point.canFormRightAngledTriangle(x, u, v));
        System.out.println("Can points 4, 5 and 8 form a right-angled triangle? --> " +
                Point.canFormRightAngledTriangle(t, u, o));
    }
}