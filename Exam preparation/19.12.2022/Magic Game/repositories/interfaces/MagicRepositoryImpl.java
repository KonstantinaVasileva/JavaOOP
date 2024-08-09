package OOP.ExamPreparation.Dec19_2022.magicGame.repositories.interfaces;

import OOP.ExamPreparation.Dec19_2022.magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;

import static OOP.ExamPreparation.Dec19_2022.magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return data;
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null){
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return data.stream()
                .filter(d->d.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
