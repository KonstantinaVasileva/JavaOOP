package OOP.ExamPreparation.Dec19_2022.magicGame.models.magicians;

import OOP.ExamPreparation.Dec19_2022.magicGame.models.magics.Magic;

public class Wizard extends MagicianImpl {
    public Wizard(String username, int health, int protection, Magic magic) {
        super(username, health, protection, magic);
    }
}
