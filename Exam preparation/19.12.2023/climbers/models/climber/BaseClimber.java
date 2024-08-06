package climbers.models.climber;

import climbers.models.roster.Roster;
import climbers.models.roster.RosterImpl;

import static climbers.common.ExceptionMessages.CLIMBER_NAME_NULL_OR_EMPTY;
import static climbers.common.ExceptionMessages.CLIMBER_STRENGTH_LESS_THAN_ZERO;

public abstract class BaseClimber implements Climber {
    private String name;
    private double strength;
    private Roster roster;

    protected BaseClimber(String name, Double strength){
        setName(name);
        setStrength(strength);
        roster = new RosterImpl();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrength(double strength) {
        if (strength < 0){
            throw new IllegalArgumentException(CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
            this.strength = strength;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public boolean canClimb() {
        return strength > 0;
    }

    @Override
    public Roster getRoster() {
        return roster;
    }

}
