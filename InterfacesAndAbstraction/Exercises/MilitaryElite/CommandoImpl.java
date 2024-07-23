package OOP.InterfacesAndAbstraction.Exercise.MilitaryElite;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Set<MissionImpl> missionImpls;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missionImpls = new HashSet<>();
    }

    public void addMission(MissionImpl missionImpl) {
        missionImpls.add(missionImpl);

    }

    public Collection<MissionImpl> getMissions() {
        return missionImpls;
    }

    @Override
    public String toString() {
        return "Name: %s %s Id: %s Salary: %.2f\nCorps: %s\nMissions:\n%s"
                .formatted(getFirstName(), getLastName(), getId(), getSalary(), getCorps(),
                        missionImpls.isEmpty() ? "" : String.join("%n", missionImpls.toString()));
    }
    //    public void completeMission(){
//        for (MissionImpl mission : missionImpls) {
//            mission.setState(Stat.finished);
//        }
//    }

}
