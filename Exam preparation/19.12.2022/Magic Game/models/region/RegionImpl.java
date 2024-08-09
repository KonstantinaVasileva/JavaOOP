package OOP.ExamPreparation.Dec19_2022.magicGame.models.region;

import OOP.ExamPreparation.Dec19_2022.magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizard = new java.util.ArrayList<>(magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("Wizard "))
                .toList());
        List<Magician> blackWidow = new java.util.ArrayList<>(magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals("Black Widow"))
                .toList());


        while (!wizard.isEmpty() && !blackWidow.isEmpty()) {
            Magician currentWizard = wizard.get(0);
            Magician currentBlackWidow = blackWidow.get(0);

            currentBlackWidow.takeDamage(currentWizard.getMagic().fire());
            if (currentBlackWidow.isAlive()) {
                currentWizard.takeDamage(currentBlackWidow.getMagic().fire());
                if (!currentWizard.isAlive()){
                    wizard.remove(currentWizard);
                }
            } else {
                blackWidow.remove(currentBlackWidow);
            }
        }
        String output;
        if (wizard.stream().noneMatch(Magician::isAlive)) {
            output = "Black widows win!";
        } else {
            output = "Wizards win!";
        }
        return output;
    }
}
