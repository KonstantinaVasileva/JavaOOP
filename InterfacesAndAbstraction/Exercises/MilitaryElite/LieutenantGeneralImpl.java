package OOP.InterfacesAndAbstraction.Exercise.MilitaryElite;

import java.util.HashSet;
import java.util.Set;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral{
    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new HashSet<>() {
        };
    }

    public void addPrivate(Private priv){
            privates.add(priv);
        }

    @Override
    public String toString() {
        return "Name: %s %s Id: %s Salary: %.2f\nPrivates:\n  %s"
                .formatted(getFirstName(), getLastName(), getId(), getSalary(),
                        String.join(System.lineSeparator(), privates.toString().replaceAll("[\\[\\]]", "")));
    }
}
