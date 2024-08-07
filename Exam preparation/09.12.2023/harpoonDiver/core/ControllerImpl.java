package harpoonDiver.core;

import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.util.Collection;
import java.util.List;

import static harpoonDiver.common.ConstantMessages.*;
import static harpoonDiver.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Diver> diverRepository;
    private Repository<DivingSite> divingSiteRepository;
    private int count;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver = switch (kind) {
            case "DeepWaterDiver" -> new DeepWaterDiver(diverName);
            case "OpenWaterDiver" -> new OpenWaterDiver(diverName);
            case "WreckDiver" -> new WreckDiver(diverName);
            default -> throw new IllegalArgumentException(DIVER_INVALID_KIND);
        };
        diverRepository.add(diver);
        return DIVER_ADDED.formatted(kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        for (String seaCreature : seaCreatures) {
            divingSite.getSeaCreatures().add(seaCreature);
        }
        divingSiteRepository.add(divingSite);
        return DIVING_SITE_ADDED.formatted(siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = diverRepository.byName(diverName);
        boolean removed = diverRepository.remove(diver);
        if (!removed) {
            throw new IllegalArgumentException(DIVER_DOES_NOT_EXIST.formatted(diverName));
        }
        return DIVER_REMOVE.formatted(diverName);
    }

    @Override
    public String startDiving(String siteName) {

        Collection<Diver> divers = diverRepository.getCollection().stream()
                .filter(d -> d.getOxygen() > 30).toList();
        Diving diving = new DivingImpl();
        if (divers.isEmpty()) {
            throw new IllegalArgumentException(SITE_DIVERS_DOES_NOT_EXISTS);
        }

        diving.searching(divingSiteRepository.byName(siteName), divers);
        count++;
        long removedDiverCount = divers.stream()
                .filter(d -> d.getOxygen() == 0)
                .count();

        return SITE_DIVING.formatted(siteName, removedDiverCount);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder(FINAL_DIVING_SITES.formatted(count));
        output.append(System.lineSeparator());
        output.append(FINAL_DIVERS_STATISTICS).append(System.lineSeparator());
        diverRepository.getCollection()
                .forEach(d -> {
                    output.append(FINAL_DIVER_NAME.formatted(d.getName())).append(System.lineSeparator());
                    output.append(FINAL_DIVER_OXYGEN.formatted(d.getOxygen())).append(System.lineSeparator());
                    output.append(FINAL_DIVER_CATCH.formatted(
                            d.getSeaCatch().getSeaCreatures().isEmpty() ?
                                    "None" :
                                    String.join(FINAL_DIVER_CATCH_DELIMITER, d.getSeaCatch().getSeaCreatures())
                    )).append(System.lineSeparator());

                });
        return output.toString();
    }
}
