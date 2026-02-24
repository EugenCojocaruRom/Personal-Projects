24FEB - Complex numbers

a) Create a Complex class. Add fields to store the relevant data, 1 constructor, possibly some getters (if needed).

b) Override these generic methods inherited from Object (use @Override in front of them to ensure you override them correctly):

&nbsp;- public boolean equals(Object other) - returns true only if other is also an instance of Complex and the 2 numbers are equal (both their parts)

Question: should we also override the hashCode() method here?

&nbsp;- public String toString(): should return values like: "3 + 4i"

c) Implement this static method:

&nbsp;- static Complex complex(double real, double imaginary) - creates a new instance of Complex using the values of the 2 parameters; is basically just a 'shortcut' for the rest of code to create instances of Complex more easily (calling just complex(..) vs new Complex(..))

Question: after adding this static method, could we make the class constructor 'private'?

d) Implement these methods for arithmetic operations on complex numbers:

&nbsp;- Complex add(Complex other): adds 'this' and 'other' as complex numbers and returns a new Complex instance

(hint: (a+bi) + (c+di) = (a+c) + (b+d)i )

&nbsp;- Complex negate(): returns a new Complex number representing the negative value of this

(hint: if z=(a+bi) then: -z = (-a-bi) )

&nbsp;- Complex multiply(Complex other): multiplies 'this' with 'other' as complex numbers and returns the result as a new Complex instance

(hint: (a+bi)(c+di) = (ac−bd) + (ad+bc)i )

