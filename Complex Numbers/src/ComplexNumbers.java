import java.util.Objects;

public class ComplexNumbers {

    //Declare private member variable for the real part
    private double re;
    //Declare private member variable for the imaginary part
    private double im;

    /* Constructor --> It can be made private to gain more control over the creation of Complex numbers.
    A private constructor would force users to create new complex numbers using solely the static method.*/
    public ComplexNumbers(double real, double imaginary) {
        this.re = real;
        this.im = imaginary;
    }

    /* Getters --> not really necessary in this case, but could be useful in other scenarios
    (e.g. accessing the real or imaginary parts from outside the class, like in a test or from another class) */
    public double getReal() {
        return re;
    }
    public double getImaginary() {
        return im;
    }

    //Define the method for checking if two complex numbers are identical
    @Override
    public boolean equals(Object obj) {
        //Set the condition for comparing the 2 variables
        if (this == obj) {
            return true;
        }
        //Set the condition for checking if the number is null or if it is indeed a complex number
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        //Convert the object into a complex number (by casting)
        ComplexNumbers other = (ComplexNumbers) obj;
        //Return the result by comparing the real and imaginary parts of the 2 numbers
        return Double.compare(this.re, other.re) == 0 && Double.compare(this.im, other.im) == 0;
    }

    /* hashCode override --> must be done whenever equals() is overridden.
    Hash-based collections such as HashMap or HashSet use the hashCode() method to decide the bucket where an object is stored.
    After locating the bucket, the equals() method is used to compare objects.
    If two objects are equal according to equals(), they must have the same hashCode(). So:
     - equals() compares name and id to check logical equality
     - hashCode() returns the same value for equal objects
    Thus, if only equals() is overridden, the objects are placed in different buckets.
    So, two complex numbers may be mathematically equal, but a HashSet/HashMap won't be able to find the correct value/key because it's looking in the wrong "bucket".
    */
    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    //Define method for returning the complex number as a string in the form (re, im)
    @Override
    public String toString() {
        return re + " + " + im + "i";
    }

    //Method for creating a new instance of Complex using the values of the 2 parameters
    static ComplexNumbers complex(double re, double im) {
        return new ComplexNumbers(re, im);
    }

    //Add complex numbers --> (a + b*i) + (c + d*i) = (a + c) + (b + d) * i
    public ComplexNumbers add(ComplexNumbers other) {
        //Return the result of the addition
        return new ComplexNumbers(this.re + other.re, this.im + other.im);
    }

    //Negate complex numbers (i.e. negative value)
    public ComplexNumbers negate() {
        return new ComplexNumbers(-this.re, -this.im);
    }

    //Multiplication of complex numbers --> (a + b*i) * (c + d*i) = (a * c - b * d) + (b * c + a * d) * i
    public ComplexNumbers multiply(ComplexNumbers other) {
        //Compute the real part
        double newRe = (this.re * other.re) - (this.im * other.im);
        //Compute the imaginary part
        double newIm = (this.im * other.re) + (this.re * other.im);
        //Return the result of the multiplication
        return new ComplexNumbers(newRe, newIm);
    }
}
