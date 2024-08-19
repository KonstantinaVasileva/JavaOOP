package OOP.SOLID.Exercise;

import OOP.SOLID.Exercise.products.Product;

import java.util.List;

public class Print {
    protected static final String SUM = "Sum: %f";
    protected static final String AVERAGE = "Average: %f";

     Calculator calculator;

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
