package OOP.Reflection.Exercise.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            String command = input.split("_")[0];
            int number = Integer.parseInt(input.split("_")[1]);

            invoke(clazz, command, blackBoxInt, number);

            System.out.println(innerValue.get(blackBoxInt));
        }

    }

    private static void invoke(Class<BlackBoxInt> clazz, String command, BlackBoxInt blackBoxInt, int number) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = clazz.getDeclaredMethod(command, int.class);
        method.setAccessible(true);
        method.invoke(blackBoxInt, number);
    }
}
