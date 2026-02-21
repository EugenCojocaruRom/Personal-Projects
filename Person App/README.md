21FEB - Person app
Create a class Person, which will model some properties of a real person.
Add these members to the class:

* fields: name, birthYear, hairColor (all private)
* constructors: add the necessary constructors, in such a way as to enforce these rules:

Notes:

* name, birthYear are mandatory - should be requested for building any Person instance;
* hairColor is optional - not strictly needed, when not specified the new Person should be set to use the default 'brown' color.
* create 2 constructors, one with a hairColor param and one without, and use "this()" to avoid repeating code between them
* getters/setters - add only the ones needed so that we can later read all properties of the person, but can modify only the hairColor field (3 getters and 1 setter)

Other methods:

* boolean isOlderThan(Person other) - returns true if the current person instance is older than the given 'other' person
* public String toString() - returns a description of the current person (with all his properties), as a single String (which we can then print..)
* int getAgeInYear(int year) - returns the age the person would be/was in the given year (may be in the future or in the past), or 0 if the year was before his birth.
