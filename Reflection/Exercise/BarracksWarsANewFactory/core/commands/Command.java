package OOP.Reflection.Exercise.BarracksWarsANewFactory.core.commands;

import OOP.Reflection.Exercise.BarracksWarsANewFactory.interfaces.Executable;
import OOP.Reflection.Exercise.BarracksWarsANewFactory.interfaces.Repository;
import OOP.Reflection.Exercise.BarracksWarsANewFactory.interfaces.UnitFactory;

public class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String[] getData() {
        return data;
    }

    public Repository getRepository() {
        return repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }

    @Override
    public String execute() {
        return null;
    }
}
