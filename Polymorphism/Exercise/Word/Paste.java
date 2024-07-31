package OOP.Polymorphism.Exercise.Word;

public class Paste implements TextTransform {

    private Cut cut;

    public Paste(Cut cut) {
        this.cut = cut;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        text.replace(startIndex, endIndex, cut.getCut());
    }
}
