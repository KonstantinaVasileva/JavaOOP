package OOP.ExamPreparation.Apr16_2024.dolphinarium.entities.foods;

public abstract class BaseFood implements Food{
    private int calories;

    protected BaseFood(int calories) {
        this.calories = calories;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}
