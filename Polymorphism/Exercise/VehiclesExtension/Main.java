package OOP.Polymorphism.Exercise.VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));

        String[] busInfo = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

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
                    case "Bus" -> bus.driveNonEmpty(number);
                }
            } else if (commandName.equals("DriveEmpty")) {
                bus.drive(number);
            } else {
                switch (type) {
                    case "Car" -> car.refuel(number);
                    case "Truck" -> truck.refuel(number);
                    case "Bus" -> bus.refuel(number);
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }

}
