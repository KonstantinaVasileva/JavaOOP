package OOP.Polymorphism.Exercise.Calculator;

public class Extensions extends InputInterpreter{
    public Extensions(CalculationEngine engine) {
        super(engine);
    }

    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new InputInterpreter(engine);
    }
}
