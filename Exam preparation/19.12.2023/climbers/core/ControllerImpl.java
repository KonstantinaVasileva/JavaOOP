package climbers.core;

import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.Climbing;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;
import climbers.repositories.Repository;

import java.util.Collection;

import static climbers.common.ConstantMessages.*;
import static climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Climber> climberRepositories;
    private Repository<Mountain> mountainRepositories;
    private int mountainCount;

    public ControllerImpl() {
        this.climberRepositories = new ClimberRepository();
        this.mountainRepositories = new MountainRepository();
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber = switch (type) {
            case "RockClimber" -> new RockClimber(climberName);
            case "WallClimber" -> new WallClimber(climberName);
            default -> throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        };
        climberRepositories.add(climber);
        return CLIMBER_ADDED.formatted(type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        for (String peak : peaks) {
            mountain.getPeaksList().add(peak);
        }
        mountainRepositories.add(mountain);
        return MOUNTAIN_ADDED.formatted(mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        boolean removed = climberRepositories.remove(climberRepositories.byName(climberName));
        if (!removed) {
            throw new IllegalArgumentException(CLIMBER_DOES_NOT_EXIST.formatted(climberName));
        }
        return CLIMBER_REMOVE.formatted(climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Collection<Climber> climbers = climberRepositories.getCollection();
        if (climbers.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }
        Climbing climbing = new ClimbingImpl();
        climbing.conqueringPeaks(mountainRepositories.byName(mountainName), climbers);
        long climberRemoved = climbers.stream()
                .filter(c->c.getStrength() == 0).count();
        mountainCount++;
        return PEAK_CLIMBING.formatted(mountainName, climberRemoved);
    }

    @Override
    public String getStatistics() {
        StringBuilder output =
                new StringBuilder(mountainCount == 0 ? "None" : FINAL_MOUNTAIN_COUNT.formatted(mountainCount));
        output.append(System.lineSeparator());
        output.append(FINAL_CLIMBERS_STATISTICS).append(System.lineSeparator());
        climberRepositories.getCollection()
                .forEach(c -> {
                    output.append(FINAL_CLIMBER_NAME.formatted(c.getName())).append(System.lineSeparator());
                    output.append(FINAL_CLIMBER_STRENGTH.formatted(c.getStrength())).append(System.lineSeparator());
                    output.append(FINAL_CLIMBER_PEAKS
                            .formatted(String.join(FINAL_CLIMBER_FINDINGS_DELIMITER, c.getRoster().getPeaks())));
                    output.append(System.lineSeparator());
                });
        return output.toString();
    }
}
