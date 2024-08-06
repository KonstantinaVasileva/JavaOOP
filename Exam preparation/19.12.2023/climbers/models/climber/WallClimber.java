package climbers.models.climber;

public class WallClimber extends BaseClimber{
    public WallClimber(String name) {
        super(name, 90.00);
    }

    @Override
    public void climb() {
        double newStrength = getStrength() - 30;
        setStrength(Math.max(0, newStrength));
    }
}
