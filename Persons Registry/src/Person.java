public class Person {

    //Declare variables for CNP, name, age and hasVoted
    private int cnp;
    private String name;
    private int age;
    private boolean hasVoted;

    //Constructor
    public Person(int cnp, String name, int age, boolean hasVoted) {
        //Set condition for the case when the CNP value is <= 0
        if (cnp <= 0) {
            //Display error message
            throw new IllegalArgumentException("Incorrect CNP. The CNP number must be greater than 0.");
        }
        //Set condition for the case when the name is null or empty
        if (name == null || name.isEmpty()) {
            //Display error message
            throw new IllegalArgumentException("The person name cannot be empty.");
        }
        //Set condition for the case when the agen is <= 0
        if (age <= 0) {
            //Display error message
            throw new IllegalArgumentException("Incorrect age. The person age must be greater than 0.");
        }
        this.cnp = cnp;
        this.name = name;
        this.age = age;
        this.hasVoted = hasVoted;
    }

    //Getters
    public int getCnp() {
        return cnp;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    //Method for checking that there are no 2 persons with the same CNP
    @Override
    public boolean equals(Object o) {
        //Check that the object is the same as the current person being checked
        if (this == o) return true;
        //Check that the object is not null or the classes of the 2 objects are different
        if (o == null || getClass() != o.getClass()) return false;
        //Cast the object to Person so it can be checked based on the Person-specific fields
        Person person = (Person) o;
        //Compare and return the CNP (i.e. unique ID)
        return cnp == person.cnp; //If the ID matches, it's the same person
    }

    //'hashCode' method for returning the CNP value
    @Override
    public int hashCode() {
        return cnp;
    }

    //'toString' method for printing the details about the persons
    @Override
    public String toString() {
        return "Person{cnp=" + cnp +
                ", name='" + name +
                "', age=" + age +
                ", voted=" + hasVoted + "}";
    }
}
