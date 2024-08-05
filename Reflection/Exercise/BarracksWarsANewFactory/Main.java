package OOP.Reflection.Exercise.BarracksWarsANewFactory;

import OOP.Reflection.Exercise.BarracksWarsANewFactory.interfaces.Repository;
import OOP.Reflection.Exercise.BarracksWarsANewFactory.interfaces.Runnable;
import OOP.Reflection.Exercise.BarracksWarsANewFactory.interfaces.UnitFactory;
import OOP.Reflection.Exercise.BarracksWarsANewFactory.core.Engine;
import OOP.Reflection.Exercise.BarracksWarsANewFactory.core.factories.UnitFactoryImpl;
import OOP.Reflection.Exercise.BarracksWarsANewFactory.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
