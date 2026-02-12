import java.text.DecimalFormat;
import java.util.*;

public class BuildingRegistry {
    //Returns the number of distinct categories present in the buildings list
    public static int categoriesCount(List<Building> buildings) {
        //Use HashSet to get the distinct categories present in the buildings list
        Set<Category> uniqueCategories = new HashSet<>();
        for (Building building : buildings) {
            uniqueCategories.add(building.getCategory());
        }
        return uniqueCategories.size();
    }

    //Returns a sorted list of unique neighborhood names
    public static List<String> neighborhoodsList(List<Building> buildings) {
        //Use TreeSet to sort the values and prevent duplicates
        Set<String> neighborhoods = new TreeSet<>();
        for (Building building : buildings) {
            neighborhoods.add(building.getNeighborhood());
        }
        return new ArrayList<>(neighborhoods);
    }

    //Returns the average price for buildings of a specific category
    //Return type is double (the average price)
    public static double averagePriceForOneCategory(List<Building> buildings, Category category) {
        //Declare variables for sum and counter of buildings in the category
        double sum = 0;
        int count = 0;
        for (Building building : buildings) {
            if (building.getCategory() == category) { // or building.getCategory().equals(category)
                sum += building.getPrice();
                count++;
            }
        }
        return Double.parseDouble(df.format(sum / count));
    }

    //Returns a map with average price for each category
    //Return type is Map<Category, Double>
    public static Map<Category, Double> averagePricePerCategory(List<Building> buildings) {
        Map<Category, Double> result = new HashMap<>();
        DecimalFormat df = new DecimalFormat("#.#");
        //Group buildings by category
        for (Category category : Category.values()) {
            double sum = 0;
            int count = 0;
            for (Building building : buildings) {
                if (building.getCategory() == category) { // or building.getCategory().equals(category)
                    sum += building.getPrice();
                    count++;
                }
            }
            // Only add to map if there are buildings in this category
            if (count > 0) {
                result.put(category, Double.valueOf(df.format(sum / count)));
            }
            //Alternative: uncomment below to include categories with 0 buildings as well
//             else {
//                 result.put(category, 0.0);
//             }
        }
        return result;
    }

    //Returns a map with average price for each neighborhood
    //Return type is Map<String, Double>
    public static Map<String, Double> averagePricePerNeighborhood(List<Building> buildings) {
        Map<String, Double> sumPerNeighborhood = new HashMap<>();
        Map<String, Integer> countPerNeighborhood = new HashMap<>();
        //Calculate sum and count for each neighborhood
        for (Building building : buildings) {
            String neighborhood = building.getNeighborhood();
            sumPerNeighborhood.put(neighborhood,
                    sumPerNeighborhood.getOrDefault(neighborhood, 0.0) + building.getPrice());
            countPerNeighborhood.put(neighborhood,
                    countPerNeighborhood.getOrDefault(neighborhood, 0) + 1);
        }
        //Calculate averages
        DecimalFormat df = new DecimalFormat("#.#");
        Map<String, Double> result = new HashMap<>();
        for (String neighborhood : sumPerNeighborhood.keySet()) {
            double average = sumPerNeighborhood.get(neighborhood) /
                    countPerNeighborhood.get(neighborhood);
            result.put(neighborhood, Double.valueOf(df.format(average)));
        }
        return result;
    }
}
