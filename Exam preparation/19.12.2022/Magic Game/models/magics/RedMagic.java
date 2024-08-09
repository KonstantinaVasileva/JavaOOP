package OOP.ExamPreparation.Dec19_2022.magicGame.models.magics;

public class RedMagic extends MagicImpl{
    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        setBulletsCount(getBulletsCount() - 1);
        return Math.max(0, getBulletsCount());
    }
}
