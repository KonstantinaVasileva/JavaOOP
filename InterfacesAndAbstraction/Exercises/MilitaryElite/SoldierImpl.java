package OOP.InterfacesAndAbstraction.Exercise.MilitaryElite;

public class SoldierImpl implements Soldier{
    private String firstName;
    private String lastName;
    private int id;

    public SoldierImpl( int id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getId() {
        return id;
    }
}
