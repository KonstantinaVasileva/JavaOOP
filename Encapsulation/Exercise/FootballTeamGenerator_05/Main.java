package OOP.Encapsulation.Exercise.FootballTeamGenerator_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> teams = new ArrayList<>();

        while (true) {
            String[] input = scanner.nextLine().split(";");
            if (input[0].equals("END")) {
                break;
            }
            String command = input[0];
            switch (command) {
                case "OOP.Encapsulation.Exercise.FootballTeamGenerator_05.Team":
                    Team team = new Team(input[1]);
                    teams.add(team);
                    break;
                case "Add":
                    Team team1 = teams.stream().filter(e -> e.getName().equals(input[1])).findFirst().orElse(null);
                    if (team1 != null) {
                        try {
                            Player player = new Player(input[2], Integer.parseInt(input[3]), Integer.parseInt(input[4]),
                                    Integer.parseInt(input[5]), Integer.parseInt(input[6]), Integer.parseInt(input[7]));
                            team1.addPlayer(player);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;
                case "Remove":
                    try {
                        teams.stream().filter(e -> e.getName().equals(input[1])).findFirst().orElse(null).removePlayer(input[2]);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    System.out.printf("%s - %d", input[1],
                            Math.round(teams.stream().filter(e -> e.getName().equals(input[1])).findFirst().orElse(null).getRating()));
                    break;
            }
        }

    }
}