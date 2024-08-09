package OOP.ExamPreparation.Dec19_2022.magicGame.repositories.interfaces;

import OOP.ExamPreparation.Dec19_2022.magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;

import static OOP.ExamPreparation.Dec19_2022.magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {

    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return data;
    }

    @Override
    public void addMagician(Magician model) {
        if (model == null){
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return data.remove(model);
    }

    @Override
    public Magician findByUsername(String name) {
        return data.stream()
                .filter(d->d.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }
}
