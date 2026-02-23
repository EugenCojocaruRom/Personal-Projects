23FEB - Triangle points app
Create a class Point for modeling a 2D point:
Add some fields to store the values for 2 coordinates (x,y of type double).
Add one constructor for easily building new points with given x,y values;
Add some methods:
 - public String toString() - should return a string description of the point (including the values of x/y); make sure you declare this one as 'public' and exactly with this signature (has a special meaning for Java)
 - double distanceTo(Point other) - should return the computed distance between this and another point
Hint1: using Pythagoras theorem, the distance between the 2 points in a plane is: dist = squareRoot(deltaX^2 +deltaY^2) - where deltaX/Y are the difference between the x/y coordinates of the 2 points, and ^2 means the power of 2 for that value
Hint2: for computations, you may use use these static methods from java.lang.Math class: sqrt(), pow(). For a nicer/more compact code, try importing them directly, using a static import (instead of regular import of whole Math class)
 - void move(double deltaX, double deltaY) - should move the current point in plane, by updating its current coordinates (add to each x,y the given deltaX/Y)
Add some static methods, which we can then use to check if a list of any three Point instances can be the corners of a regular or a right-angled triangle:
 - static boolean canFormTriangle(Point p1, Point p2, Point p3)
 - static boolean canFormRightAngledTriangle(Point p1, Point p2, Point p3)
Hint: to implement these, you could first compute the 3 distances between each of the pairs of 2 points (this being the sides of our possible triangle).