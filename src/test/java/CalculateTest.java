import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTest {

    @Test(expected = IllegalArgumentException.class)
    public void result_ERR() {
        new Calculate("60 / 0").result();
    }

    @Test(expected = IllegalArgumentException.class)
    public void result_ERR1() {
        new Calculate("XX / 0").result();
    }

    @Test(expected = IllegalArgumentException.class)
    public void result_ERR2() {
        new Calculate("60 $ 50").result();
    }

    @Test(expected = IllegalArgumentException.class)
    public void result_ERR3() {
        new Calculate("60 + MC").result();
    }

    @Test(expected = IllegalArgumentException.class)
    public void result_ERR4() {
        new Calculate("XXL + 50").result();
    }

    @Test(expected = IllegalArgumentException.class)
    public void result_ERR5() {
        new Calculate("60 +50").result();
    }

    @Test(expected = IllegalArgumentException.class)
    public void result_ERR6() {
        new Calculate("60- 50").result();
    }

    @Test(expected = IllegalArgumentException.class)
    public void result_ERR47() {
        new Calculate("MM + MM").result();
    }

    @Test
    public void result_OK() {
        assertEquals("110", new Calculate("60 + 50").result());
    }

    @Test
    public void result_OK1() {
        assertEquals("-10", new Calculate("50 - 60").result());
    }

    @Test
    public void result_OK2() {
        assertEquals("3000", new Calculate("60 * 50").result());
    }

    @Test
    public void result_OK3() {
        assertEquals("2", new Calculate("60 / 30").result());
    }

    @Test
    public void result_OK4() {
        assertEquals("XXI", new Calculate("XX + I").result());
    }

    @Test
    public void result_OK5() {
        assertEquals("XII", new Calculate("XXXV - XXIII").result());
    }

    @Test
    public void result_OK6() {
        assertEquals("MMDXLII", new Calculate("XLI * LXII").result());
    }

    @Test
    public void result_OK7() {
        assertEquals("X", new Calculate("XCI / IX").result());
    }
}