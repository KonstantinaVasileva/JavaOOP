package handball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTests {

    private Team team;
    private HandballPlayer handballPlayer;

    @BeforeEach
    public void setUp(){
        team = new Team("Bulgaria", 2);
        handballPlayer = new HandballPlayer("Ivan");
    }

    @Test
    public void getName_returnCorrectResult(){
        Assertions.assertEquals("Bulgaria", team.getName());
    }

    @Test
    public void throwExp_whenNameIsNull(){
        Assertions.assertThrows(NullPointerException.class, () -> new Team(null, 2));
    }

    @Test
    public void throwExp_whenNameIsBlank(){
        Assertions.assertThrows(NullPointerException.class, () -> new Team(" ", 2));
    }

    @Test
    public void getPosition_returnCorrectResult(){
        Assertions.assertEquals(2, team.getPosition());
    }

    @Test
    public void throwExp_whenPositionIsNegative(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Team("Bulgaria", -2));
    }

    @Test
    public void getCount_returnCorrectResult(){
        Assertions.assertEquals(0, team.getCount());
    }

    @Test
    public void addPlayer_whenNoSpace_throwExp(){
        HandballPlayer handballPlayer1 = new HandballPlayer("Ivan");
        HandballPlayer handballPlayer2 = new HandballPlayer("Ivan");
        team.add(handballPlayer1);
        team.add(handballPlayer2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.add(handballPlayer));
    }

    @Test
    public void removePlayer_whoNotExist_throwExp(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.remove(handballPlayer.getName()));
    }

    @Test
    public void removePlayerCorrectly(){
        team.add(handballPlayer);
        Assertions.assertEquals(1, team.getCount());
        team.remove("Ivan");
        Assertions.assertEquals(0, team.getCount());
    }

   @Test
    public void check_ifPlayer_doNotPlayForAnotherTeam_throwExp(){
        team.add(handballPlayer);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> team.playerForAnotherTeam("Pesho"));
   }

    @Test
    public void check_ifPlayer_playForAnotherTeam_changeActiveToFalse(){
        team.add(handballPlayer);
        team.playerForAnotherTeam("Ivan");
        Assertions.assertFalse(handballPlayer.isActive());
    }
}
