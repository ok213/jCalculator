import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralTest {

    @Test
    public void toString1() {
        assertEquals("XXI", new RomanNumeral(21).toString());
    }

    @Test
    public void toString2() {
        assertEquals("MMMCMXCIX", new RomanNumeral(3999).toString());
    }

    @Test(expected = NumberFormatException.class)
    public void toString3() {
        new RomanNumeral(4000).toString();
    }

    @Test(expected = NumberFormatException.class)
    public void toString4() {
        new RomanNumeral(-1).toString();
    }

    @Test
    public void toInt() {
        assertEquals(21, new RomanNumeral("XXI").toInt());
    }

    @Test
    public void toInt_NEGATIVE() {
        assertEquals(3999, new RomanNumeral("MMMCMXCIX").toInt());
    }

    @Test(expected = NumberFormatException.class)
    public void toInt2() {
        new RomanNumeral("-XXI").toInt();
    }

    @Test(expected = NumberFormatException.class)
    public void toInt3() {
        new RomanNumeral("MMMY").toInt();
    }
}