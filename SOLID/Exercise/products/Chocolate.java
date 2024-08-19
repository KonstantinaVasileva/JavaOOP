package OOP.SOLID.Exercise.products;

public class Chocolate implements Food{

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private double grams;

    public Chocolate(double grams) {
        this.grams = grams;
    }

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
