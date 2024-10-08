package OOP.InterfacesAndAbstraction.Exercise.MilitaryElite;

public class SpyImpl extends SoldierImpl implements Spy{
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return "Name: %s %s Id: %s\nCode Number: %s"
                        .formatted(getFirstName(), getLastName(), getId(), codeNumber);
    }
}
