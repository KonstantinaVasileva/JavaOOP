package OOP.Polymorphism.Exercise.Word;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        return new CommandImpl(text);
    }

}
