public class Main {
    public static void main(String[] args) {

        //Test examples
        ComplexNumbers c1 = ComplexNumbers.complex(1, 2);
        ComplexNumbers c2 = ComplexNumbers.complex(3, 4);
//        Complex c3 = Complex.complex(5, 6);

        //manual testing
        System.out.println("c1: " + c1 + ", c2: " + c2);
        System.out.println("!c1 = " + c1.negate());
        System.out.println("c1+c2 = " + c1.add(c2));
        System.out.println("c1*c2 = " + c1.multiply(c2));
//        System.out.println("c3 is: " + c3.getReal() + " + " + c3.getImaginary() + "i");
    }
}