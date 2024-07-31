package OOP.Polymorphism.Exercise.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            String commandName = command[0];
            String type = command[1];
            double number = Double.parseDouble(command[2]);

            if (commandName.equals("Drive")){
                switch (type) {
                    case "Car" -> car.drive(number);
                    case "Truck" -> truck.drive(number);
                }
            } else {
                switch (type) {
                    case "Car" -> car.refuel(number);
                    case "Truck" -> truck.refuel(number);
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);

    }

}
