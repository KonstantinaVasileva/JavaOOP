package OOP.WorkingWithAbstraction.Exercise.GreedyTimes_06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());

        String[] input = scanner.nextLine().split("\\s+");
        Bag gold = new Bag("Gold");
        Bag gem = new Bag("Gem");
        Bag cash = new Bag("Cash");

        for (int i = 0; i < input.length; i += 2) {
            String name = input[i];
            long amount = Long.parseLong(input[i + 1]);
            if (name.isBlank()||name.isEmpty()){
                continue;
            }
            Treasure treasure = new Treasure(name, amount);
            if (gold.totalTreasureAmount() + gem.totalTreasureAmount() + cash.totalTreasureAmount() + amount <= capacity) {
                if (name.equalsIgnoreCase("gold")) {
                    if (gold.totalTreasureAmount() + amount >= gem.totalTreasureAmount()) {
                        gold.addTreasure(treasure);
                    }
                } else if (name.toLowerCase().endsWith("gem") && name.length() >= 4) {
                    if (gem.totalTreasureAmount() + amount >= cash.totalTreasureAmount()
                            && gold.totalTreasureAmount() >= gem.totalTreasureAmount() + amount) {
                        gem.addTreasure(treasure);
                    }
                } else if (name.length() == 3) {
                    if (gem.totalTreasureAmount() >= cash.totalTreasureAmount() + amount) {
                        cash.addTreasure(treasure);
                    }
                }
            }
        }

        System.out.println(gold.totalTreasureAmount() != 0 ? gold : "");
        System.out.println(gem.totalTreasureAmount() != 0 ? gem : "");
        System.out.println(cash.totalTreasureAmount() != 0 ? cash : "");
    }
}
