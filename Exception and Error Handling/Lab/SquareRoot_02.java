package OOP.ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            int num = Integer.parseInt(input);
            if (num >0) {
                System.out.println("%.2f".formatted(Math.sqrt(num)));
            }else {
                System.out.println("Invalid");
            }
        } catch (NumberFormatException ignored){
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }
}
