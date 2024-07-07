package OOP.WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class RhombusOfStars_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printRhombus(n);
    }

    private static void printRhombus(int n) {
        for (int row = 1; row <= n; row++) {
            halfOfRhombus(n, row);
        }

        for (int row = n - 1; row >= 1; row--) {
            halfOfRhombus(n, row);
        }
    }

    private static void halfOfRhombus(int n, int row) {
        for (int i = 1; i <= n - row; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= row; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
