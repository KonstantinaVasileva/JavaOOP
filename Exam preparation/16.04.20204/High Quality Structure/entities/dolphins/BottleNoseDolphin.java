package OOP.ExamPreparation.Apr16_2024.dolphinarium.entities.dolphins;

public class BottleNoseDolphin extends BaseDolphin{
    public BottleNoseDolphin(String name, int energy) {
        super(name, energy);
    }


    @Override
    public void jump() {
        setEnergy(200);
    }

}
