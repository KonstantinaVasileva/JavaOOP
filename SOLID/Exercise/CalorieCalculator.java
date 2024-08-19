package OOP.SOLID.Exercise;

import OOP.SOLID.Exercise.products.Chocolate;
import OOP.SOLID.Exercise.products.Coke;
import OOP.SOLID.Exercise.products.Lemonade;
import OOP.SOLID.Exercise.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator{

    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.amountOfCalories();
        }

        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }


}
