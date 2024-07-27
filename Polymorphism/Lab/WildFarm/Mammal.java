package OOP.Polymorphism.Lab.WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    protected String livingRegion;
    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }


    @Override
    public void eat(Food food) {
        foodEaten += food.quantity;
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "%s[%s, %s, %s, %d]".formatted(animalType, animalName, df.format(animalWeight), livingRegion, foodEaten);
    }
}
