package OOP.ExamPreparation.Apr16_2024.dolphinarium.entities.dolphins;

import OOP.ExamPreparation.Apr16_2024.dolphinarium.entities.foods.Food;

import static OOP.ExamPreparation.Apr16_2024.dolphinarium.common.ExceptionMessages.DOLPHIN_NAME_NULL_OR_EMPTY;

public abstract class BaseDolphin implements Dolphin {
    private String name;
    private int energy;

    protected BaseDolphin(String name, int energy) {
        setName(name);
        this.energy = energy;
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(DOLPHIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(int energy) {
        this.energy -= energy;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    public void eat(Food food) {
        energy += food.getCalories();
    }
}
