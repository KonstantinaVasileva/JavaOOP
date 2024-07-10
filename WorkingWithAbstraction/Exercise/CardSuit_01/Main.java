package OOP.WorkingWithAbstraction.Exercise.CardSuit_01;

public class Main {
    public static void main(String[] args) {

        Suit[] suits = Suit.values();
        System.out.println("Card Suits:");
        for (Suit suit : suits) {
            System.out.printf("Ordinal value: %s; Name value: %s%n", suit.ordinal(), suit);

        }
    }
}
