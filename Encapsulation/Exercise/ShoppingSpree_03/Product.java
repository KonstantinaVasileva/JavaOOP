package OOP.Encapsulation.Exercise.ShoppingSpree_03;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    private void setName(String name) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        return cost;
    }

    private void setCost(double cost) {
        this.cost = cost;
    }

}
