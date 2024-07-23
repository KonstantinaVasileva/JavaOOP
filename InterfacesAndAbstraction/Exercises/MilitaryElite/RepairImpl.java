package OOP.InterfacesAndAbstraction.Exercise.MilitaryElite;

public class RepairImpl {
    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "Part Name: %s Hours Worked: %s"
                .formatted(partName, hoursWorked);
    }
}
