package OOP.Reflection.Lab.CreateAnnotation;


public class Main {
    public static void main(String[] args) {

        Class<Test> clazz = Test.class;

        Subject annotation = clazz.getAnnotation(Subject.class);
        for (String category : annotation.categories()) {
            System.out.println(category);
        }
    }
}
