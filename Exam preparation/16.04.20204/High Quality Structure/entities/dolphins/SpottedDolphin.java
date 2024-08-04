package OOP.ExamPreparation.Apr16_2024.dolphinarium.entities.dolphins;

public class SpottedDolphin extends BaseDolphin{
    public SpottedDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        setEnergy(100);
    }
}
