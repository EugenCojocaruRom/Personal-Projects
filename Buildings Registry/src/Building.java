public class Building {
    
    //Fields
    private Category category;
    private double price;
    private String neighborhood;

    //Constructor
    public Building(Category category, double price, String neighborhood) {
        this.category = category;
        this.price = price;
        this.neighborhood = neighborhood;
    }

    //Getters
    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getNeighborhood() {
        return neighborhood;
    }
}
