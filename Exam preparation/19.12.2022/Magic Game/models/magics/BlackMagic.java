package OOP.ExamPreparation.Dec19_2022.magicGame.models.magics;

public class BlackMagic extends MagicImpl{
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        setBulletsCount(getBulletsCount() - 10);
        return Math.max(0, getBulletsCount());
    }
}
