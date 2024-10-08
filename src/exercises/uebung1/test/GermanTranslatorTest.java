package exercises.uebung1.test;

import exercises.uebung1.control.GermanTranslator;
import exercises.uebung1.view.Client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GermanTranslatorTest {

    @Test
    public void posTest() {
        /* Zahl ist im Bereich von 1-10 */
        GermanTranslator translator = new GermanTranslator();
        Client client = new Client();

        assertEquals("fünf" , translator.translateNumber(5));
    }

    @Test
    public void neg1Test() {
        /* Zahl > 10 */
        GermanTranslator translator = new GermanTranslator();

        assertThrows(IllegalArgumentException.class, ()->{translator.translateNumber(13);});
    }

    @Test
    public void neg2Test() {
        /* Zahl < 10 */
        GermanTranslator translator = new GermanTranslator();

        assertThrows(IllegalArgumentException.class, ()->{translator.translateNumber(-1);});
    }

    @Test
    public void neg3Test() {
        /* Zahl = 0 */
        GermanTranslator translator = new GermanTranslator();

        assertThrows(IllegalArgumentException.class, ()->{translator.translateNumber(0);});
    }




}
