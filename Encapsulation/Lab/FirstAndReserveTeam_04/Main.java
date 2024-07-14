package OOP.Encapsulation.Lab.FirstAndReserveTeam_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int players = Integer.parseInt(scanner.nextLine());

        Team team = new Team("Black Eagles");

        for (int i = 0; i < players; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person person = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
            team.addPlayer(person);
        }

        System.out.printf("First team have %s players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %s players%n", team.getReserveTeam().size());
    }
}
