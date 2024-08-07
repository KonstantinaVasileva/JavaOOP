package handball.core;

import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private Repository equipment;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay = switch (gameplayType) {
            case "Outdoor" -> new Outdoor(gameplayName);
            case "Indoor" -> new Indoor(gameplayName);
            default -> throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        };
        gameplays.add(gameplay);
        return SUCCESSFULLY_ADDED_GAMEPLAY_TYPE.formatted(gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment1 = switch (equipmentType) {
            case "Kneepad" -> new Kneepad();
            case "ElbowPad" -> new ElbowPad();
            default -> throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        };
        equipment.add(equipment1);
        return SUCCESSFULLY_ADDED_EQUIPMENT_TYPE.formatted(equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment byType = equipment.findByType(equipmentType);
        if (byType == null){
            throw new IllegalArgumentException(NO_EQUIPMENT_FOUND.formatted(equipmentType));
        }
        Gameplay gameplay = gameplays.stream()
                .filter(g -> g.getName().equals(gameplayName)).findFirst().orElse(null);
        gameplay.addEquipment(byType);
        equipment.remove(byType);
        return SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY.formatted(equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team = switch (teamType){
            case "Bulgaria" -> new Bulgaria(teamName, country, advantage);
            case "Germany" -> new Germany(teamName, country, advantage);
            default -> throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        };
        String output;
        if ((team.getClass().getSimpleName().equals("Bulgaria")
                && gameplays.getClass().getSimpleName().equals("Outdoor"))
        ||(team.getClass().getSimpleName().equals("Germany") && gameplayName.equals("Indoor"))){
            output = SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY.formatted(teamType, gameplayName);
        } else {
            output = GAMEPLAY_NOT_SUITABLE;
        }
        return output;
    }

    @Override
    public String playInGameplay(String gameplayName) {
        long count = gameplays.stream().filter(g -> g.getName().equals(gameplayName)).count();
        return TEAMS_PLAYED.formatted(count);
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        int value = gameplays.stream()
                .filter(g -> g.getName().equals(gameplayName))
                .flatMapToInt(d -> d.getTeam().stream()
                        .mapToInt(Team::getAdvantage)).sum();
        return ADVANTAGE_GAMEPLAY.formatted(gameplayName, value);
    }

    @Override
    public String getStatistics() {
        return String.join(System.lineSeparator(), gameplays.toString().replaceAll("[\\[\\]]", ""));
    }
}
