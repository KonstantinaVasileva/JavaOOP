package OOP.WorkingWithAbstraction.Exercise.GreedyTimes_06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String type;
    private List<Treasure> treasures;

    public Bag(String type) {
        this.type = type;
        this.treasures = new ArrayList<>();
    }

    public long totalTreasureAmount() {
        return treasures.stream().mapToLong(Treasure::getAmount).sum();
    }

    public void addTreasure(Treasure treasure) {
        for (int i = 0; i < treasures.size(); i++) {
            if (treasures.get(i).getName().equalsIgnoreCase(treasure.getName())) {
                treasures.set(i, new Treasure(treasure.getName(), treasures.get(i).getAmount() + treasure.getAmount()));
                return;
            }
        }
        treasures.add(treasure);
    }

    @Override
    public String toString() {
        treasures.sort(Comparator.reverseOrder());
//        StringBuilder output = new StringBuilder();
//        output.append(String.format("<%s> $%s\n", type, totalTreasureAmount()));
//        for (int i = 0; i < treasures.size() - 1; i++) {
//            output.append(String.format("##%s - %s\n", treasures.get(i).getName(), treasures.get(i).getAmount()));
//        }
//        output.append(String.format("##%s - %s", treasures.get(treasures.size() - 1).getName(), treasures.get(treasures.size() - 1).getAmount()));
//        return String.valueOf(output);
         return String.format("<%s> $%s%n%s", type, totalTreasureAmount(),
                 treasures.stream().map(e -> "##" + e.getName() + " - " + e.getAmount()).collect(Collectors.joining(System.lineSeparator())));

    }

}
