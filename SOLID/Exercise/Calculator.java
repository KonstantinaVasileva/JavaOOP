package OOP.SOLID.Exercise;

import OOP.SOLID.Exercise.products.Product;

import java.util.List;

public interface Calculator {
    double sum(List<Product> products);
    double average(List<Product> products);
}
