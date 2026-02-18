import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonsRegistryImpl implements PersonsRegistry {

    //Use Map for indexing by CNP
    private final Map<Integer, Person> persons = new HashMap<>();

    /**
     * Adds a new person to the registry. If a person with same CNP already exists,
     * it will NOT register this new person (just ignore it, and show an error)
     */
    public void register(Person p) {
        //Set condition for preventing null input
        if (p == null) {
            System.out.println("Cannot register a null person.");
            return;
        }
        //Set condition for checking duplicate CNPs
        if (persons.containsKey(p.getCnp())) {
            System.out.println("Cannot register a duplicate person. CNP " + p.getCnp() + " already exists.");
        }
        //Add the person
        else {
            persons.put(p.getCnp(), p);
        }
    }

    /**
     * Finds a person by cnp and removes it from registry
     * If person not found, will still work (does nothing, but raises no error either)
     */
    public void unregister(int cnp) {
        //Check if the CNP exists
        if (persons.containsKey(cnp)) {
            //Remove the person if the CNP exists
            persons.remove(cnp);
        }
        //Display error message if the CNP does not exist
        else {
            System.out.println("CNP does not exist. Cannot unregister.");
        }
    }

    /**
     * Get the number of currently registered persons
     */
    public int count() {
        //Return the number of registered persons
        return persons.size();
    }

    /**
     * Get the list of distinct cnp values of all persons
     */
    public Set<Integer> cnps() {
        //Return a Set with the CNPs of all the registered persons
        return new HashSet<>(persons.keySet());
    }

    /**
     * Get the list of distinct names of all persons
     */
    public Set<String> uniqueNames() {
        //Declare Set of type String to hold the names of the registered persons
        Set<String> names = new HashSet<>();
        //Loop through the 'persons' Map
        for (Person p : persons.values()) {
            //Add each name to the Set
            names.add(p.getName());
        }
        //Return the set of names
        return names;
    }

    /**
     * Find a person by cnp. Returns null if no person found.
     */
    public Person findByCnp(int cnp) {
        if (!persons.containsKey(cnp)) {
//            System.out.println("CNP does not exist.");
            return null;
        }
        else {
            return persons.get(cnp);
        }
    }

    /**
     * Find the persons with a specified name (may be zero, one or more)
     * (comparing person name with specified name should be case insensitive)
     */
    public Set<Person> findByName(String name) {
        //Set condition for the case when attempting to search by a null value
        if (name == null) {
            //Display message
            System.out.println("Cannot find a null name.");
        }
        //Declare Set of type Person for storing the result of the search
        Set<Person> result = new HashSet<>();
        //Loop through the 'persons' Map
        for (Person p : persons.values()) {
            //Set condition for the case when the name exists in the Map
            if (p.getName().equalsIgnoreCase(name)) {
                //Add the name to the Set
                result.add(p);
            }
        }
        return result;
    }

    /**
     * Get the average age for all persons (or 0 as default if it cannot be computed)
     */
    public double averageAge() {
        //Set condition for the case when there are no persons registered
        if (persons.isEmpty()) {
            //Display message
            System.out.println("Cannot calculate average age.");
        }
        //Declare variable of type double and initialize it
        double totalAge = 0;
        //Loop through the 'persons' Map
        for (Person p : persons.values()) {
            //Calculate the total age by adding the age of each person at each iteration
            totalAge += p.getAge();
        }
        //Return the average age
        return totalAge / persons.size();
    }

    /**
     * Get the percent (a value between 0-100) of adults (persons with age >=18)
     * from the number of all persons (or 0 as default if it cannot be computed)
     */
    public double adultsPercentage() {
        //Set condition for the case when there are no persons registered
        if (persons.isEmpty()) {
            //Display message
            System.out.println("Cannot calculate adults percentage.");
        }
        //Declare variable of type double (counter) and initialize it
        int adultsNumber = 0;
        //Loop through the 'persons' Map
        for (Person p : persons.values()) {
            //Check if the age is >= 18
            if (p.getAge() >= 18) {
                //Increment the number of adults counter at each iteration
                adultsNumber++;
            }
        }
        //Return the percentage of adults
        return (double) (adultsNumber * 100) / persons.size();
    }

    /**
     * Get the percent (a value between 0-100) of adults who voted
     * from the number of all adult persons (age>=18)
     */
    public double adultsWhoVotedPercentage() {
        //
        if (persons.isEmpty()) {
            //Display message
            System.out.println("Cannot calculate the number of adults who voted.");
        }
        //Declare variable of type int and initialize it - number of adults
        int adultsNumber = 0;
        //Declare variable of type int and initialize it - number of voters
        int voters = 0;
        //Loop through the 'persons' Map
        for (Person p : persons.values()) {
            //Check if the age is >= 18
            if (p.getAge() >= 18) {
                //Increment the number of adults counter at each iteration
                adultsNumber++;
                //Check if the person has voted
                if (p.hasVoted()) {
                    //Increment the number of voters at each iteration
                    voters++;
                }
            }
        }
        //Return 0 if there are no adults
        if (adultsNumber == 0) {
            return 0;
        }
        //Return the percentage of adult voters
        return (double) (voters * 100) / adultsNumber;
    }
}
