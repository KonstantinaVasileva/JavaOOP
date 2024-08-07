package handball.entities.team;

public class Germany extends BaseTeam{
    public Germany(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    //I can only play Indoor!
    @Override
    public void play() {
        setAdvantage(getAdvantage() + 145);
    }
}
