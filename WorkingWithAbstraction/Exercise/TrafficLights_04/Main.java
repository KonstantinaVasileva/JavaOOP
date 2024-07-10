package OOP.WorkingWithAbstraction.Exercise.TrafficLights_04;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrafficLights[] trafficLights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLights::valueOf).toArray(TrafficLights[]::new);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            changeLight(trafficLights);
            for (TrafficLights trafficLight : trafficLights) {
                System.out.print(trafficLight + " ");
            }

            System.out.println();
        }
    }

    public static void changeLight(TrafficLights[] trafficLights) {
        for (int i = 0; i < trafficLights.length; i++) {
            switch (trafficLights[i]) {
                case RED -> {
                    trafficLights[i] = TrafficLights.GREEN;
                }
                case GREEN -> {
                    trafficLights[i] = TrafficLights.YELLOW;
                }
                case YELLOW -> {
                    trafficLights[i] = TrafficLights.RED;
                }
                default -> throw new IllegalArgumentException();

            }
        }
    }
}
