package OOP.Reflection.Lab.HightQualityMistake;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;

        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f-> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f-> System.out.printf("%s must be private!%n", f.getName()));

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m->m.getName().contains("get") && !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.printf("%s have to be public!%n", m.getName()));

        Arrays.stream(methods)
                .filter(m->m.getName().contains("set") && !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.printf("%s have to be private!%n", m.getName()));
    }
}
