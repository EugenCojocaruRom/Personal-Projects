public class Point {

    /* Variables
     --> set as private for encapsulation purposes, allows access control
     --> not final, as this would prevent the move() method from updating x and y */
    private double x;
    private double y;

    //Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /* Getters & Setters --> not necessarily needed, as all the methods that need x and y
    are inside the Point class itself (they have direct access to private fields) */

    //toString method
    @Override
    public String toString() {
        return "(" + "x=" + x + ", y=" + y + ")";
    }

    //Compute distance between this and another point
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    //Move the current point in plane, by updating its current coordinates
    public void move(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    //Check if triangle is possible
    public static boolean canFormTriangle(Point p1, Point p2, Point p3) {
        double side1 = p1.distanceTo(p2);
        double side2 = p2.distanceTo(p3);
        double side3 = p1.distanceTo(p3);
        //Handle the case when any of the sides is 0 (i.e. triangle cannot exist)
        if (side1 == 0 || side2 == 0 || side3 == 0) {
            return false;
        }
        return ((side1 + side2) > side3) && ((side1 + side3) > side2) && ((side2 + side3) > side1);
    }

    //Check if the triangle is a right-angled triangle
    private static final double EPSILON = 1e-9;
    public static boolean canFormRightAngledTriangle(Point p1, Point p2, Point p3) {
        //Set condition to check first if a triangle can be formed
        if (!canFormTriangle(p1, p2, p3)) {
            return false;
        }
        //Variables
        double side1 = p1.distanceTo(p2);
        double side2 = p2.distanceTo(p3);
        double side3 = p1.distanceTo(p3);

        //Normally, the method would return the values below (commented out):
//        return ((Math.pow(side1, 2) + Math.pow(side2, 2) == Math.pow(side3, 2)) ||
//                (Math.pow(side1, 2) + Math.pow(side3, 2) == Math.pow(side2, 2)) ||
//                (Math.pow(side2, 2) + Math.pow(side3, 2) == Math.pow(side1, 2)));

        /* But, given that comparing floating-point numbers using '==' might lead to precision errors,
        it appears it's better to use an EPSILON tolerance, and the Math.abs() method instead of Math.pow() */
        return (Math.abs(side1 + side2 - side3) < EPSILON) ||
                (Math.abs(side1 + side3 - side2) < EPSILON) ||
                (Math.abs(side2 + side3 - side1) < EPSILON);
    }
}
