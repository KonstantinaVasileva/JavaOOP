package OOP.ExamPreparation.Dec19_2022.magicGame.models.magicians;

import OOP.ExamPreparation.Dec19_2022.magicGame.models.magics.Magic;

public interface Magician {
    String getUsername();

    int getHealth();

    int getProtection();

    Magic getMagic();

    boolean isAlive();

    void takeDamage(int points);
}
