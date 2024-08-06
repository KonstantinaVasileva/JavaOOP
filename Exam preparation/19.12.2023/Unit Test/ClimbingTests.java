package stuntClimb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClimbingTests {

    private RockClimber rockClimber;
    private Climbing climbing;

    @BeforeEach
    public void setUp() {
        rockClimber = new RockClimber("Ivan", 20);
        climbing = new Climbing("Brave", 2);
    }

    @Test
    public void getCount_returnCorrectResult(){
        Assertions.assertEquals(0, climbing.getCount());
        climbing.addRockClimber(rockClimber);
        Assertions.assertEquals(1, climbing.getCount());
    }

    @Test
    public void getName_returnCorrectResult(){
        climbing.addRockClimber(rockClimber);
        Assertions.assertEquals("Brave", climbing.getName());
    }

    @Test
    public void getCapacity_returnCorrectResult(){
        Assertions.assertEquals(2, climbing.getCapacity());
    }

    @Test
    public void addCLimber_whenNotEnoughCapacity_throwExp(){
        RockClimber rockClimber1 = new RockClimber("Pesho", 18);
        RockClimber rockClimber2 = new RockClimber("Gosho", 22);
        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> climbing.addRockClimber(rockClimber));
    }

    @Test
    public void addCLimber_whenAlreadyExist_throwExp(){
        climbing.addRockClimber(rockClimber);
        Assertions.assertThrows(IllegalArgumentException.class, () -> climbing.addRockClimber(rockClimber));
    }

    @Test
    public void removeClimber_returnCorrectBoolean(){
        Assertions.assertFalse(climbing.removeRockClimber(rockClimber.getName()));
        climbing.addRockClimber(rockClimber);
        Assertions.assertTrue(climbing.removeRockClimber(rockClimber.getName()));
    }
    @Test
    public void throwExp_whenSetNegativeCapacity(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Climbing("Long Way", -1));
    }

    @Test
    public void throwExp_whenNameIsNull(){
        Assertions.assertThrows(NullPointerException.class,
                () -> new Climbing(null, 5));
    }

    @Test
    public void throwExp_whenNameIsWhiteSpace(){
        Assertions.assertThrows(NullPointerException.class,
                () -> new Climbing(" ", 5));
    }
}
