package OOP.ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers_03 {
    public static List<Integer> listOfNumbers;
    public static int start;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start = 1;
        int end = 100;
        listOfNumbers = new ArrayList<>();
        while (listOfNumbers.size() < 10) {
            String input = scanner.nextLine();
            readNumber(end, input);
        }
        System.out.println(String.join(", ", listOfNumbers.toString()).replaceAll("[\\[\\]]", ""));

    }

    public static void readNumber(int end, String input) {
        try {
            int number = Integer.parseInt(input);
            if (number > start && number < end) {
                start = number;
                listOfNumbers.add(number);
            } else {
                System.out.printf("Your number is not in range %d - %d!%n", start, end);
            }
        } catch (NumberFormatException ignored){
            System.out.println("Invalid Number!");
        }
    }
}
