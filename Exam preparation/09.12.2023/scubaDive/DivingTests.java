package scubaDive;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivingTests {

    private DeepWaterDiver diver;
    private Diving diving;

    @BeforeEach
    public void setUp(){
        diver = new DeepWaterDiver("Ivan", 10);
        diving = new Diving("Brave", 2);
    }

    @Test
    public void getCount_returnCorrectResult(){
        diving.addDeepWaterDiver(diver);
        Assertions.assertEquals(1, diving.getCount());
    }

    @Test
    public void getName_returnCorrectName(){
        diving.addDeepWaterDiver(diver);
        Assertions.assertEquals("Brave", diving.getName());
    }

    @Test
    public void getCapacity_returnCorrectResult(){
        Assertions.assertEquals(2, diving.getCapacity());
    }

    @Test
    public void addDiver_whenNotEnoughSpace_throwExp(){
        DeepWaterDiver diver1 = new DeepWaterDiver("Peso", 10);
        DeepWaterDiver diver2 = new DeepWaterDiver("Gosho", 8);
        diving.addDeepWaterDiver(diver1);
        diving.addDeepWaterDiver(diver2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> diving.addDeepWaterDiver(diver));
    }

    @Test
    public void addDiver_whenHiAlreadyExist_throwExp(){
        diving.addDeepWaterDiver(diver);
        Assertions.assertThrows(IllegalArgumentException.class, () -> diving.addDeepWaterDiver(diver));
    }

    @Test
    public void removeDiver_returnFalse_whenHiNotExist(){
        Assertions.assertFalse(diving.removeDeepWaterDiver(diver.getName()));
    }

    @Test
    public void removeDiver_returnTrue_whenHiNotExist(){
        diving.addDeepWaterDiver(diver);
        Assertions.assertTrue(diving.removeDeepWaterDiver(diver.getName()));
    }

    @Test
    public void throwExp_whenCapacityIsNegative(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Diving("test", -1));
    }

    @Test
    public void throwExp_whenNameIsNull(){
        Assertions.assertThrows(NullPointerException.class, () -> new Diving(null, 2));
    }

    @Test
    public void throwExp_whenNameIsBlank(){
        Assertions.assertThrows(NullPointerException.class, () -> new Diving(" ", 2));
    }
}
