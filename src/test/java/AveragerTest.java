import org.junit.Test;

import org.junit.*;
import static org.junit.Assert.*;

public class AveragerTest {

    private Averager dummyAverager;

    @Before
    public void setUp() {
        dummyAverager = new Averager(1, 1 );
    }


    @Test
    public void testAveragesForOneAndOne(){
        double expected = 1.0;
        double actual = dummyAverager.getAverage();

        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testAveragesFailsForOneAndOne(){
        double expected = 1.6;
        double actual = dummyAverager.getAverage();

        assertNotEquals(expected, actual, 0.1);
    }


}