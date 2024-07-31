package OOP.Polymorphism.Exercise.Word;

public class Cut implements TextTransform{

    private String cut;
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        String temp = text.substring(startIndex, endIndex);
        text.delete(startIndex, endIndex);
        setCut(temp);
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }
}
