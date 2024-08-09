package OOP.ExamPreparation.Dec19_2022.magicGame.core;

import OOP.ExamPreparation.Dec19_2022.magicGame.models.magicians.BlackWidow;
import OOP.ExamPreparation.Dec19_2022.magicGame.models.magicians.Magician;
import OOP.ExamPreparation.Dec19_2022.magicGame.models.magicians.Wizard;
import OOP.ExamPreparation.Dec19_2022.magicGame.models.magics.BlackMagic;
import OOP.ExamPreparation.Dec19_2022.magicGame.models.magics.Magic;
import OOP.ExamPreparation.Dec19_2022.magicGame.models.magics.RedMagic;
import OOP.ExamPreparation.Dec19_2022.magicGame.models.region.Region;
import OOP.ExamPreparation.Dec19_2022.magicGame.models.region.RegionImpl;
import OOP.ExamPreparation.Dec19_2022.magicGame.repositories.interfaces.MagicRepositoryImpl;
import OOP.ExamPreparation.Dec19_2022.magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;

import static OOP.ExamPreparation.Dec19_2022.magicGame.common.ExceptionMessages.*;
import static OOP.ExamPreparation.Dec19_2022.magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGIC;
import static OOP.ExamPreparation.Dec19_2022.magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN;

public class ControllerImpl implements Controller {

    private MagicianRepositoryImpl magicians;
    private MagicRepositoryImpl magics;
    private Region region;

    public ControllerImpl() {
        this.magicians = new MagicianRepositoryImpl();
        this.magics = new MagicRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {

        Magic magic = switch (type) {
            case "RedMagic" -> new RedMagic(name, bulletsCount);
            case "BlackMagic" -> new BlackMagic(name, bulletsCount);
            default -> throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        };
        magics.addMagic(magic);
        return SUCCESSFULLY_ADDED_MAGIC.formatted(name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = magics.findByName(magicName);
        if (magic == null) {
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }
        Magician magician = switch (type) {
            case "Wizard" -> new Wizard(username, health, protection, magic);
            case "BlackWidow" -> new BlackWidow(username, health, protection, magic);
            default -> throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);

        };
        magicians.addMagician(magician);
        return SUCCESSFULLY_ADDED_MAGICIAN.formatted(username);
    }

    @Override
    public String startGame() {
        return region.start(magicians.getData());
    }

    @Override
    public String report() {

        List<Magician> collect = magicians.getData().stream().sorted(Comparator.comparing(Magician::getHealth)
                .thenComparing(Magician::getUsername)).toList();

        StringBuilder output = new StringBuilder();
        collect.forEach(c-> output.append(c.toString().formatted(c.getClass().getSimpleName())).append(System.lineSeparator()));
        return output.toString().trim();


        //"{magician type}: {magician username}
        // Health: {magician health}
        // Protection: {magician protection}
        // Magic: {magician magic name}"

    }
}
