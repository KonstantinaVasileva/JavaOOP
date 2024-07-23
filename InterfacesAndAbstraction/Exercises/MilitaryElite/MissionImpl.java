package OOP.InterfacesAndAbstraction.Exercise.MilitaryElite;

public class MissionImpl {

    private String codeName;
    private String  state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Code Name: %s State: %s"
                .formatted(codeName, state);
    }
}
