package OOP.Encapsulation.Exercise.FootballTeamGenerator_05;

import OOP.Encapsulation.Exercise.FootballTeamGenerator_05.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        if (!players.removeIf(e -> e.getName().equals(name))) {
            throw new IllegalArgumentException(String.format("OOP.Encapsulation.Exercise.FootballTeamGenerator_05.Player %s is not in %s team.", name, this.name));
        }
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }

}
