package OOP.Encapsulation.Exercise.ShoppingSpree_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");
        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        for (String p : people) {
            String name = p.split("=")[0];
            int money = Integer.parseInt(p.split("=")[1]);
            Person person = new Person(name, money);
            personList.add(person);
        }
        for (String s : products) {
            String name = s.split("=")[0];
            double cost = Double.parseDouble(s.split("=")[1]);
            Product product = new Product(name, cost);
            productList.add(product);
        }

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input[0].equals("END")) {
                break;
            }
            String personName = input[0];
            String productName = input[1];

            Person person1 = personList.stream().filter(e -> e.getName().equals(personName)).findFirst().get();
            Product product1 = productList.stream().filter(e -> e.getName().equals(productName)).findFirst().get();
            person1.buyProduct(product1);

        }
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}

