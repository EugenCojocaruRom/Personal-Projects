public class Main {
    public static void main(String[] args) {

        //Some test data
        System.out.println("Welcome to the Room App");
        Room room = new Room(5);
        room.printAll();

        //Creating persons using the Person class and its constructors
        Person pers1 = new Person("Eugene", 1979);
        Person pers2 = new Person("Jane", 1988, "blonde");
        Person pers3 = new Person("Maria", 2012, "brown");
        Person pers4 = new Person("Julie", 2001, "red");
        Person pers5 = new Person("Sam", 1998, "black");
        Person pers6 = new Person("Chris", 2004, "brown");
        Person pers7 = new Person("Michaela", 1965, "blonde");
        Person pers8 = new Person("Matilda", 2002, "black");
        Person pers9 = new Person("Samantha", 2000, "blonde");
        Person pers10 = new Person("Julie", 2004);
        Person pers11 = new Person("Simon", 1950, "grey");
        Person pers12 = new Person("Andrew", 1981, "black");

        //Add persons to the room
        System.out.println("\n<=== Add persons ===>");
        room.enter(pers1);
        room.enter(pers2);
        room.enter(pers3);
        room.enter(pers4);
        room.enter(pers5);
        room.enter(pers6);
        room.enter(pers7);
        room.enter(pers8);
        room.enter(pers9);
        room.enter(pers10);
        room.enter(pers11);
        room.enter(pers12);

        //Display persons added
        room.printAll();

        //Person present in the room
        System.out.println("\n<=== Presence in the room ===>");
        System.out.println("Is Julie in the room? --> " + room.isPresent("Julie"));
        System.out.println("Is Tracy in the room? --> " + room.isPresent("Tracy"));

        //Oldest person in the room
        System.out.println("\n<=== Oldest person in the room ===>");
        System.out.println("The oldest person in the room is " + room.getOldest());

        //Names of people with hair of a certain color
        System.out.println("\n<=== People with blonde hair ===>");
        String[] blondeHairPeople = room.getNames("blonde");
        for (String name : blondeHairPeople) {
            System.out.println(name);
        }

        //Remove people from the room
        System.out.println("\n<=== Removing people from the room ===>");
        System.out.println("Removing Chris...");
        room.exit("Chris");
        room.printAll();
        System.out.println("Removing Samantha...");
        room.exit("Samantha");
        room.printAll();
        System.out.println("Removing Eugene...");
        room.exit("Eugene");
        room.printAll();
        //Attempt to remove a person that was already removed or was never present in the room
        System.out.println("Removing Jim...");
        room.exit("Jim");
        room.printAll();
    }
}