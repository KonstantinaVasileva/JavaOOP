package OOP.SOLID.Exercise.products;

public class Chips implements Food{
    public static final double CALORIES_PER_100_GRAMS = 529.0;
    private double grams;


    public double getGrams() {
        return grams;
    }

    @Override
    public double getKiloGrams() {
        return grams / 1000;
    }

    @Override
    public double amountOfCalories() {
        return CALORIES_PER_100_GRAMS * grams;
    }
}
