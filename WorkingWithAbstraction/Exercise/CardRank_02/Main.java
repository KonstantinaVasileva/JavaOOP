package OOP.WorkingWithAbstraction.Exercise.CardRank_02;

public class Main {
    public static void main(String[] args) {
        Rank[] ranks = Rank.values();
        System.out.println("Card Ranks:");
        for (Rank rank : ranks) {
            System.out.printf("Ordinal value: %s; Name value: %s%n", rank.ordinal(), rank);

        }
    }
}
