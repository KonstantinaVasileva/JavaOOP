package OOP.Encapsulation.Exercise.ShoppingSpree_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money >= product.getCost()) {
            products.add(product);
            System.out.printf("%s bought %s\n", name, product.getName());
            money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s%n", name, product.getName()));
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s", name,
                products.isEmpty() ? "Nothing bought"
                        : products.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return products;
    }
}
