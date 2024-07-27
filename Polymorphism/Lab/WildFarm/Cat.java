package OOP.Polymorphism.Lab.WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }


    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "%s[%s, %s, %s, %s, %s]"
                .formatted(animalType, animalName, breed, df.format(animalWeight), livingRegion, foodEaten);
    }
}
