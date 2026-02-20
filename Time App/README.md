20FEB - Time app

a) Class definition:



Create a class named Time. Create 2 separate instances of it. Check if they are equal (using the "==" operator).

Question: why does "==" return that result for this case?

Add 3 fields to the Time class: hours, minutes, seconds (all of type int).

Create an instance of Time class and set all its fields to some values (like: 1:10:30).

Create a method in Time class, with signature String description(), which returns a description of this Time instance as a single String value, with format "<hour>:<minutes>:<seconds>" (replacing <..> with the actual values of this instance fields). Test it on a few different Time instance (with fields manually set to different values)

Question: could we make this method 'static'? (why yes/no?)

&nbsp;

b) Constructors:

Add one constructor to Time class, which receives 3 parameters and uses them to initialize the 3 class fields. Test that it works ok. (create some instances, print them out using description())

Add some validation code to your constructor so it will ignore any negative values (will not set the fields for those parameters, leaving them set to default 0 value). Test it.

Add a 2nd constructor to Time class, this one having no parameters and setting the field values to 23:59:59. Test it.



c) Methods:

Add a method int secondsSinceMidnight() which computes and returns the number of seconds since start of current day (0:0:0) up to the current value of Time instance. Test it on a few Time instances.

Add a method int secondsSince(Time) which receives another Time instance as a parameter, and returns the number of seconds between that time and the current instance's time (value may be negative or positive, depending on their order).





d) Access levels:

You decided that you want to 'protect' the instances of your Time class from unexpected changes of values from other parts of the code, while the application is running.

Change your code so that the fields of Time instances cannot be changed after they were built (making Time instances "immutable"):

&nbsp;- make the fields "private" (optional: make them also "final")

&nbsp;- add just some getters (but no setters) for them.

Then check that you can still read the fields (like hours) from outside the Time class, by using the getters, but you cannot modify them in any way.





e) Static members:

Add to your Time class a public static field createInstancesCounter (type int) and change your code (constructors) so each time a new instance is created, this counter is incremented. Create then 3 new instances of Time class and print the value of this counter after each instance creation.

Create a new class TimeUtils and then add a method to it, static String descriptionOf(Time t) which receives as input parameter an instance of Time and returns the values of its fields as a single String value, in format "<hour>:<minutes>:<seconds>". Test it on the previously created Time instances.

Question: as we already have the non-static method 'description()' in the Time class itself, can you think of any reasons / scenarios why it would it be useful to also have this similar static method outside the Time class?..

\[Optional] make the new method return the time in the 12-hours format with "AM/PM" suffix, like: "11:50:01 AM", "12:01:01 PM", "1:15:02 PM"





f) Methods, algorithms:

Add another method to the Time class, boolean isAfter(Time other), which receives another time instance, compares their values and returns true if the current instance represents a moment in time which is chronologically after the moment represented by other instance.

Add another static method to the TimeUtils class: static Time findLatest(Time\[] times), which receives an array of Time instances and returns the one which is chronologically the latest of them all, meaning is after all others. Note: your code should only read the array values, but not modify them in any way.

Question: Do you have any special cases to consider? What happens if you receive an empty array? (what value could we return then?)

&nbsp;



g) \[Optional]: change the description() method of Time class in this way: rename it to "toString" and make it public. It should now have the signature "public String toString()", but return the same value like the old method.

