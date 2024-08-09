package OOP.ExamPreparation.Dec19_2022.magicGame.repositories.interfaces;

import OOP.ExamPreparation.Dec19_2022.magicGame.models.magics.Magic;

import java.util.Collection;

public interface MagicRepository<T> {
    Collection<T> getData();

    void addMagic(Magic model);

    boolean removeMagic(Magic model);

    T findByName(String name);
}
