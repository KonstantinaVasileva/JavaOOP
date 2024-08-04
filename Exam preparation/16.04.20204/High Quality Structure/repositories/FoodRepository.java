package OOP.ExamPreparation.Apr16_2024.dolphinarium.repositories;

import OOP.ExamPreparation.Apr16_2024.dolphinarium.entities.foods.Food;

//TODO Implement all methods
public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
