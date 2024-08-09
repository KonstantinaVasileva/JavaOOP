package OOP.ExamPreparation.Dec19_2022.magicGame;

import OOP.ExamPreparation.Dec19_2022.magicGame.core.Engine;
import OOP.ExamPreparation.Dec19_2022.magicGame.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
