package dolphinsPlay;

//TODO write unit tests

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayDolphinsTests {
    private Dolphin dolphin;
    private DolphinsPlay dolphinsPlay;

    @BeforeEach
    public void setUp() {
        dolphin = new Dolphin("Spinner", "Woolly", 5);
        dolphinsPlay = new DolphinsPlay("Pool", 1);
    }

    @Test
    public void getDolphins_returnUnmodifiableList(){
        dolphinsPlay.addDolphin(dolphin);
        List<Dolphin> dolphins = dolphinsPlay.getDolphins();
        assertThrows(UnsupportedOperationException.class, () -> dolphins.remove(0));
    }

    @Test
    public void returnCorrectSize_When_GetCount() {
        assertEquals(0, dolphinsPlay.getCount());
        dolphinsPlay.addDolphin(dolphin);
        assertEquals(1, dolphinsPlay.getCount());
    }

    @Test
    public void addNullDolphin_Throw() {
        dolphin = null;
        assertThrows(IllegalArgumentException.class, () -> dolphinsPlay.addDolphin(dolphin));
    }

    @Test
    public void addDolphin_When_NoCapacity_Throw() {
        dolphinsPlay.addDolphin(dolphin);
        assertThrows(IllegalArgumentException.class,
                () -> dolphinsPlay.addDolphin(new Dolphin("Common", "Polly", 6)));
    }

    @Test
    public void addExistDolphin_Throw() {
        dolphinsPlay.addDolphin(dolphin);
        assertThrows(IllegalArgumentException.class, () -> dolphinsPlay.addDolphin(dolphin));
    }

    @Test
    public void whenRemoveDolphin_returnCorrectBoolean() {
        assertFalse(dolphinsPlay.removeDolphin(dolphin.getName()));
        dolphinsPlay.addDolphin(dolphin);
        assertTrue(dolphinsPlay.removeDolphin(dolphin.getName()));
    }

    @Test
    public void getTheDolphinWithTheMaxEnergy_returnCorrectDolphin(){
        DolphinsPlay dolphinsPlayTest = new DolphinsPlay("TestName", 2);
        dolphinsPlayTest.addDolphin(dolphin);
        Dolphin dolphinPolly = new Dolphin("Common", "Polly", 6);
        dolphinsPlayTest.addDolphin(dolphinPolly);
        assertEquals("Polly", dolphinsPlayTest.getTheDolphinWithTheMaxEnergy());
    }

    @Test
    public void findAllDolphinsByType_returnCorrectList(){
        DolphinsPlay dolphinsPlayTest = new DolphinsPlay("TestName", 3);
        dolphinsPlayTest.addDolphin(dolphin);
        dolphinsPlayTest.addDolphin(new Dolphin("Type", "Name", 6));
        dolphinsPlayTest.addDolphin(new Dolphin("Type", "Name2", 9));

        assertEquals(2, dolphinsPlayTest.findAllDolphinsByType("Type").size());
    }
    @Test
    public void getName_returnCorrectName(){
        dolphinsPlay.addDolphin(dolphin);
        assertEquals("Woolly", dolphin.getName());
    }
}
