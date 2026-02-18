public class Main {
    public static void main(String[] args) {

        //Some test data
        PersonsRegistry reg = new PersonsRegistryImpl();
        reg.register(new Person(1234, "Ion", 14, false));
        reg.register(new Person(2233, "Ana", 12, false));
        reg.register(new Person(2678, "Ana", 3, false));
        reg.register(new Person(1235, "Costel", 21, false));
        reg.register(new Person(2367, "Maria", 33, true));

        System.out.println("Registered persons count: " + reg.count());
        System.out.println("Average age: " + reg.averageAge());
        System.out.println("Adults percentage: " + reg.adultsPercentage());
        System.out.println("Voters percentage (vs all adults): " + reg.adultsWhoVotedPercentage());

        System.out.println("Unique names: " + reg.uniqueNames());
        System.out.println("Unique CNPs: " + reg.cnps());
        System.out.println("Persons named 'ana': " + reg.findByName("ana"));
        System.out.println("Person with cnp 2678: " + reg.findByCnp(2678));
        System.out.println("Person with cnp 1000: " + reg.findByCnp(1000));

        reg.unregister(2678);
        System.out.println("Registered persons count: " + reg.count());
        System.out.println("Person with cnp 2678: " + reg.findByCnp(2678));
    }
}