package OOP.WorkingWithAbstraction.Exercise.GreedyTimes_06;

public class Treasure implements Comparable<Treasure> {
    private String name;
    private long amount;

    public Treasure(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public int compareTo(Treasure other) {
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) {
            return nameCompare;
        } else {
            return Long.compare(other.amount, this.amount);
        }
    }
}
