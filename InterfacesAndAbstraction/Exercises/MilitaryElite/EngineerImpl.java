package OOP.InterfacesAndAbstraction.Exercise.MilitaryElite;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Set<RepairImpl> repair;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repair = new HashSet<>();
    }

    public void addRepair(RepairImpl repair) {
        this.repair.add(repair);
    }

    @Override
    public Collection<RepairImpl> getRepair() {
        return repair;
    }

    @Override
    public String toString() {
        return "Name: %s %s Id: %s Salary: %.2f\nCorps: %s\nRepairs:\n  %s"
                        .formatted(getFirstName(), getLastName(), getId(), getSalary(), getCorps(),
                                String.join("%n", repair.toString()));
    }
}
