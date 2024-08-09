package OOP.ExamPreparation.Dec19_2022.magicGame.repositories.interfaces;

import OOP.ExamPreparation.Dec19_2022.magicGame.models.magicians.Magician;

import java.util.Collection;

public interface MagicianRepository<T> {
    Collection<T> getData();

    void addMagician(Magician model);

    boolean removeMagician(Magician model);

    T findByUsername(String name);
}
