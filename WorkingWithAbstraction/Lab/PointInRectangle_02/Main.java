package OOP.WorkingWithAbstraction.Lab.PointInRectangle_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Rectangle rectangle = new Rectangle(new Point(coordinates[0], coordinates[1]), new Point(coordinates[2], coordinates[3]));

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            int[] pointCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Point point = new Point(pointCoordinates[0], pointCoordinates[1]);
            System.out.println(rectangle.contains(point));
        }
    }
}
