package OOP.Reflection.Lab.CodingTracker;

import java.util.Arrays;

public class Main {
    @Author(name = "George")
    public static void main(String[] args) {

        printMethodsByAuthor(Main.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> clazz){
        Arrays.stream(clazz.getDeclaredMethods())
                .forEach(m-> System.out.printf("%s: %s%n", m.getAnnotation(Author.class).name(),
                        m.getName()));
    }
}
