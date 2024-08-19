package OOP.ExceptionsAndErrorHandling;

import java.util.Scanner;

public class NumberInRange_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");

        int startNumber = Integer.parseInt(range[0]);
        int endNumber = Integer.parseInt(range[1]);

        System.out.printf("Range: [%d...%d]%n", startNumber, endNumber);

        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);

                if (number >= startNumber && number <= endNumber) {
                    System.out.println("Valid number: " + number);
                    break;
                }
            } catch (NumberFormatException ignored){

            }
            System.out.println("Invalid number: " + input);
        }
    }
}
