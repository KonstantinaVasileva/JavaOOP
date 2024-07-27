package OOP.Polymorphism.Lab.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lineCount = 0;
        Animal animal = null;

        List<Animal> animals = new ArrayList<>();

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input[0].equals("End")) {
                break;
            }

            if (lineCount % 2 == 0) {
                String animalType = input[0];
                String animalName = input[1];
                Double animalWeight = Double.valueOf(input[2]);
                String animalLivingRegion = input[3];

                switch (animalType) {
                    case "Cat" -> {
                        String catBreed = input[4];
                        animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                    }
                    case "Tiger" -> animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    case "Mouse" -> animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    case "Zebra" -> animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                }
                animals.add(animal);
            } else {
                String foodType = input[0];
                Integer quantity = Integer.valueOf(input[1]);
                Food food = null;
                switch (foodType){
                    case "Vegetable" -> food = new Vegetable(quantity);
                    case "Meat" -> food = new Meat(quantity);
                }
                animal.makeSound();
                animal.eat(food);
            }
            lineCount++;
        }
        for (Animal a : animals) {
            System.out.println(a);
        }
    }
}
