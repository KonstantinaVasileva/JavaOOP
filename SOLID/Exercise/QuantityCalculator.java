package OOP.SOLID.Exercise;

import OOP.SOLID.Exercise.products.Drink;
import OOP.SOLID.Exercise.products.Food;
import OOP.SOLID.Exercise.products.Product;

import java.util.List;

public class QuantityCalculator implements Calculator{


    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            if (product instanceof Food) {
                sum += ((Food) product).getKiloGrams();
            } else if (product instanceof Drink) {
                sum+= ((Drink) product).getLiters();
            }
        }

        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}