public class Person {

    //Variables
    private String name;
    private int birthYear;
    private String hairColor = "brown";

    //Constructor 1 - w hairColor
    public Person(String name, int birthYear, String hairColor) {
        this.name = name;
        this.birthYear = birthYear;
        this.hairColor = hairColor;
    }

    //Constructor 2 - w/o hairColor
    public Person(String name, int birthYear) {
        this(name, birthYear, "brown");
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getHairColor() {
        return hairColor;
    }

    //Setter - for hairColor
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    //Returns true if the current person instance is older than the given 'other' person
    public boolean isOlderThan(Person other) {
        return this.birthYear < other.birthYear;
    }

    //Returns the age the person would be/was in the given year (may be in the future or in the past), or 0 if the year was before his birth
    public int getAgeInYear(int year) {
        if (year < this.birthYear) {
            return 0;
        }
        int age = year - this.birthYear;
        if (age > 122) {
            throw new IllegalArgumentException("Impossible age of " + age + ". The oldest recorded person was 122.");
        }
        return age;
    }

    //toString - returns a description of the current person (with all his properties), as a single String (which we can then print..)
    @Override
    public String toString() {
        return "Person's personal info:\nName: " + name + "\nBirth year: " + birthYear + "\nHair color: " + hairColor;
    }
}
