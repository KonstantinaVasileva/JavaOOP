package handball.entities.team;

public class Bulgaria extends BaseTeam{

    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    //I can only play Outdoor!
    @Override
    public void play() {
        setAdvantage(getAdvantage() + 115);
    }
}
