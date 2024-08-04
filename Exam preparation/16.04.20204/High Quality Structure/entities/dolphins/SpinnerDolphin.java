package OOP.ExamPreparation.Apr16_2024.dolphinarium.entities.dolphins;

public class SpinnerDolphin extends BaseDolphin{
    public SpinnerDolphin(String name, int energy) {
        super(name, energy);
    }

    @Override
    public void jump() {
        setEnergy(50);
    }
}
