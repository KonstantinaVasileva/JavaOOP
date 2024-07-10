package OOP.WorkingWithAbstraction.Exercise.JediGalaxy_05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = new int[x][y];

        fillMatrix(x, y, matrix);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] stars = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evil[0];
            int evilCol = evil[1];

            removeEvil(evilRow, evilCol, matrix);

            int starsRow = stars[0];
            int starCol = stars[1];

            sum = calculateStars(starsRow, starCol, matrix, sum);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long calculateStars(int starsRow, int starCol, int[][] matrix, long sum) {
        while (starsRow >= 0 && starCol < matrix[1].length) {
            if (starsRow < matrix.length && starCol >= 0) {
                sum += matrix[starsRow][starCol];
            }

            starCol++;
            starsRow--;
        }
        return sum;
    }

    private static void removeEvil(int evilRow, int evilCol, int[][] matrix) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void fillMatrix(int x, int y, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
