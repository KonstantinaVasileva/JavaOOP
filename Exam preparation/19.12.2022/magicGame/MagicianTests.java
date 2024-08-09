package magicGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MagicianTests {

    private Magic magic;
    private Magician magician;

    @BeforeEach
    public void setUp(){
        magic = new Magic("Rabbit", 10);
        magician = new Magician("Merlin", 10);
    }

    @Test
    public void returnCorrectName_whenTryToGetIt(){
        Assertions.assertEquals("Merlin", magician.getUsername());
    }

    @Test
    public void throwExp_whenUsernameIsNull(){
        Assertions.assertThrows(NullPointerException.class, () -> new Magician(null, 10));
    }

    @Test
    public void throwExp_whenUsernameIsBlank(){
        Assertions.assertThrows(NullPointerException.class, () -> new Magician("  ", 10));
    }

    @Test
    public void throwExp_whenHealthIsBellowZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Magician("null", -10));
    }

    @Test
    public void whenTakeDamage_healthCanNotBeBellowZero(){
        magician.takeDamage(5);
        Assertions.assertEquals(5, magician.getHealth());
        magician.takeDamage(10);
        Assertions.assertEquals(0, magician.getHealth());
    }

    @Test
    public void throwExp_whenTakeDamage_butMagicianIsAlreadyDead(){
        magician.takeDamage(10);
        Assertions.assertEquals(0, magician.getHealth());
        Assertions.assertThrows(IllegalStateException.class, ()->magician.takeDamage(5));
    }

    @Test
    public void whenTryToAddNullMagic_throwExp(){
        Assertions.assertThrows(NullPointerException.class, ()->magician.addMagic(null));
    }

    @Test
    public void correctlyAddedMagic(){
        Assertions.assertEquals(0, magician.getMagics().size());
        magician.addMagic(magic);
        Assertions.assertEquals(1, magician.getMagics().size());
    }

    @Test
    public void removeReturnCorrectBoolean(){
        Assertions.assertFalse(magician.removeMagic(magic));
        magician.addMagic(magic);
        Assertions.assertTrue(magician.removeMagic(magic));
    }

    @Test
    public void returnCorrectMagic_whenExist(){
        magician.addMagic(magic);
        Assertions.assertEquals(magic, magician.getMagic("Rabbit"));
    }

    @Test
    public void returnNull_whenMagicNotExist(){
        magician.addMagic(magic);
        Assertions.assertNull(magician.getMagic("Rabit"));
    }
}
