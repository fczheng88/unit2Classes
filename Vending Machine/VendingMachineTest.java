

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VendingMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VendingMachineTest
{
    /**
     * Default constructor for test class VendingMachineTest
     */
    public VendingMachineTest()
    {
    }
    @Test
    public void testInit()
    {
        VendingMachine thing = new VendingMachine();
        assertEquals(10, thing.getCans());
        VendingMachine thing2 = new VendingMachine(2);
        assertEquals(2, thing2.getCans());
    }
    @Test
    public void testFillUp()
    {
        VendingMachine thing = new VendingMachine();
        thing.refill(15);
        assertEquals(25, thing.getCans());
        thing.refill(30);
        assertEquals(55, thing.getCans());
        thing.vend();
        assertEquals(1, thing.getTokens());
    }
    @Test
    public void testVend()
    {
        VendingMachine thing = new VendingMachine();
        thing.vend();
        assertEquals(9, thing.getCans());
        assertEquals(1, thing.getTokens());
    }
    @Test 
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
