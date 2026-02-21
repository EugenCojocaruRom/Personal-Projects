public class Main {
    public static void main(String[] args) {

        //Instances of Person
        Person p1 = new Person("Ion", 1989, "black");
        Person p2 = new Person("Ana", 2001, "blond");
        Person p3 = new Person("Marian", 1979);

        //Display details
        System.out.println("p1: "+ p1.toString());
        System.out.println("p2: "+ p2.toString());
        System.out.println("p1 older than p2: " + p1.isOlderThan(p2));
        System.out.println("p1 older than p3: " + p1.isOlderThan(p3));
        //Separator
        System.out.println("\n<=== Person info ===>");
        System.out.println("Person 1:\nName: " + p1.getName() +
                "\nBirth year: " + p1.getBirthYear() +
                "\nAge: " + p1.getAgeInYear(2026) +
                "\nHair color: " + p1.getHairColor());
        System.out.println("Person 2:\nName: " + p2.getName() +
                "\nBirth year: " + p2.getBirthYear() +
                "\nAge: " + p2.getAgeInYear(2026) +
                "\nHair color: " + p2.getHairColor());
        System.out.println(p3.toString());
        System.out.println("p1 age: " + p1.getAgeInYear(1979));
        System.out.println("p2 age: ");
        try {
            System.out.println(p2.getAgeInYear(2399));
        }  catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("p3 age: " + p3.getAgeInYear(2026));
        p3.setHairColor("silver blonde");
        System.out.println("Person 3 just dyed their hair " + p3.getHairColor());
    }
}