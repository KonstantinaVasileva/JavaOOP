package climbers.models.climber;

public class RockClimber extends BaseClimber{
    public RockClimber(String name) {
        super(name, 120.00);
    }

    @Override
    public void climb() {
        double newStrength = getStrength() - 60;
        setStrength(Math.max(0, newStrength));
    }
}
