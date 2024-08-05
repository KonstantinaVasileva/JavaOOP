package OOP.Reflection.Exercise.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Class<RichSoilLand> clazz = RichSoilLand.class;
		Scanner scanner = new Scanner(System.in);
		Field[] fields = clazz.getDeclaredFields();

		while (true){
			String command = scanner.nextLine();
			if (command.equals("HARVEST")){
				break;
			}
			switch (command){
				case "private":
					printPrivate(fields);
					break;
				case "protected":
					printProtected(fields);
					break;
				case "public":
					printPublic(fields);
					break;
				case "all":
					printAll(fields);
					break;
			}
		}

	}

	private static void printAll(Field[] fields) {
			Arrays.stream(fields)
					.forEach(m-> System.out.println("%s %s %s"
							.formatted(Modifier.toString(m.getModifiers()), m.getType().getSimpleName(), m.getName())));
	}

	private static void printPrivate(Field[] fields) {
		Arrays.stream(fields).filter(m-> Modifier.isPrivate(m.getModifiers()))
				.forEach(m-> System.out.println("%s %s %s"
						.formatted(Modifier.toString(m.getModifiers()), m.getType().getSimpleName(), m.getName())));
	}

	private static void printProtected(Field[] fields) {
		Arrays.stream(fields).filter(m-> Modifier.isProtected(m.getModifiers()))
				.forEach(m-> System.out.println("%s %s %s"
						.formatted(Modifier.toString(m.getModifiers()), m.getType().getSimpleName(), m.getName())));
	}

	private static void printPublic(Field[] fields) {
		Arrays.stream(fields).filter(m-> Modifier.isPublic(m.getModifiers()))
				.forEach(m-> System.out.println("%s %s %s"
						.formatted(Modifier.toString(m.getModifiers()), m.getType().getSimpleName(), m.getName())));
	}
}
