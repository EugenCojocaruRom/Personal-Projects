import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Building> buildings = Arrays.asList(
                new Building(Category.RESIDENTIAL, 250000, "Downtown"),
                new Building(Category.RESIDENTIAL, 300000, "Suburbs"),
                new Building(Category.RELIGIOUS, 1000000, "Midtown"),
                new Building(Category.OFFICE, 545000, "Downtown"),
                new Building(Category.OFFICE, 653000, "Midtown"),
                new Building(Category.OFFICE, 758000, "Uptown"),
                new Building(Category.HOSPITAL, 1000000, "Suburbs"),
                new Building(Category.HOSPITAL, 2500000, "Midtown"),
                new Building(Category.RESIDENTIAL, 275000, "Downtown"),
                new Building(Category.RELIGIOUS, 200000, "Suburbs")
        );

        System.out.println("Categories count: " +
                BuildingRegistry.categoriesCount(buildings));

        System.out.println("Neighborhoods: " +
                BuildingRegistry.neighborhoodsList(buildings));

        System.out.println("Average price for RESIDENTIAL: " +
                BuildingRegistry.averagePriceForOneCategory(buildings, Category.RESIDENTIAL));

        System.out.println("Average price for RELIGIOUS: " +
                BuildingRegistry.averagePriceForOneCategory(buildings, Category.RELIGIOUS));

        System.out.println("Average price for HOSPITAL: " +
                BuildingRegistry.averagePriceForOneCategory(buildings, Category.HOSPITAL));

        System.out.println("Average price for OFFICE: " +
                BuildingRegistry.averagePriceForOneCategory(buildings, Category.OFFICE));

        System.out.println("Average price per category: " +
                BuildingRegistry.averagePricePerCategory(buildings));

        System.out.println("Average price per neighborhood: " +
                BuildingRegistry.averagePricePerNeighborhood(buildings));
    }
}
