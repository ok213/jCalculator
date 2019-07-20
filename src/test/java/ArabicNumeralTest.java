import static org.junit.Assert.*;

public class ArabicNumeralTest {

    @org.junit.Test
    public void getNum() {
        assertEquals(101, new ArabicNumeral("101").getNum());
    }

    @org.junit.Test
    public void getNum_NEGATIVE() {
        assertEquals(-101, new ArabicNumeral("-101").getNum());
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void getNumException() {
        new ArabicNumeral("0x1A").getNum();
    }

    @org.junit.Test(expected = NumberFormatException.class)
    public void getNumException_ROMAN() {
        new ArabicNumeral("XXI").getNum();
    }
}
