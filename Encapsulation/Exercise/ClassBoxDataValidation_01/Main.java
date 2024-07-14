package OOP.Encapsulation.Exercise.ClassBoxDataValidation_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double wight = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = new Box(length, wight, height);

        System.out.printf("""
                Surface Area - %.2f
                Lateral Surface Area - %.2f
                Volume – %.2f
                """, box.calculateSurfaceArea(), box.calculateLateralSurfaceArea(), box.calculateVolume());

    }
}
