public class Room {

    //Variables
    private final int capacity;
    private Person[] persons;
    private int personsCount = 0;

    //Constructor
    public Room(int capacity) {
        this.capacity = capacity;
        persons = new Person[capacity];
    }

    //Getters
    public int getCapacity() {
        return capacity;
    }

    //Methods
    //Persons counter
    public int getCount() {
        return personsCount;
    }

    //Print all persons in the room
    public void printAll() {
        System.out.println("The room has a capacity of " + getCapacity() + " persons.");
        if (personsCount == 0) {
            System.out.println("There are no persons in the room.");
        }
        else {
            System.out.println("There are currently " + getCount() + " persons in the room.");
            for (int i = 0; i < personsCount; i++) {
                System.out.println("Person " + (i + 1) + ": " + persons[i].toString());
            }
        }
    }

    //Add person
    public void enter(Person person) {
        if (personsCount >= capacity) {
            System.out.println("The room is at full capacity.");
            return;
        }
        if (isPresent(person.getName())) {
            System.out.println("The person with name " + person.getName() + " is already present.");
            return;
        }
        else {
            persons[personsCount] = person;
            personsCount++;
        }
    }

    //Person is present in the room
    public boolean isPresent(String personName) {
        return indexOf(personName) != -1;
    }

    //Oldest person in the room
    public String getOldest() {
        if (personsCount == 0) {
            return "";
        }
        Person oldestPerson = persons[0];
        for (int i = 0; i < personsCount; i++) {
            if (oldestPerson.getBirthYear() > persons[i].getBirthYear()) {
                oldestPerson = persons[i];
            }
        }
        return oldestPerson.getName() + " (" + oldestPerson.getBirthYear() + ")";
    }

    //Names of all persons in the room that have the hairColor property equal to the given color
    public String[] getNames(String hairColor) {
        int counter = 0;
        for (int i = 0; i < personsCount; i++) {
            if (persons[i].getHairColor().equals(hairColor)) {
                counter++;
            }
        }
        String[] names = new String[counter];
        int j = 0;
        for (int i = 0; i < personsCount; i++) {
            if (persons[i].getHairColor().equals(hairColor)) {
                names[j++] = persons[i].getName();
            }
        }
        return names;
    }

    //Search and remove from room the person(s) that have the specified name
    public void exit(String personName) {
        int index = indexOf(personName);
        if (index == -1) {
            System.out.println("The person with the name " + personName + " is not in the room.");
            return;
        }
        //Shift all persons (based on index) one position to the left
        for (int i = index; i < personsCount - 1; i++) {
            persons[i] = persons[i + 1];
        }
        //Set the last slot of the 'persons' array to null after shifting all to the left
        persons[personsCount] = null;
        //Decrement the count by 1
        personsCount--;
    }

    //Helper method - indexOf
    private int indexOf(String name) {
        for (int i = 0; i < personsCount; i++) {
            if (persons[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
