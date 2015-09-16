

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CarTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CarTest
{
    /**
     * Default constructor for test class CarTest
     */
    public CarTest()
    {
    }

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
    
    @Test
    public void testAddGas()
    {
        Car car = new Car(50.0);
        car.addGas(5.0);
        assertEquals(5.0, car.getGasInTank(), 1e-6);
        car.addGas(7.0);
        assertEquals(12.0, car.getGasInTank(), 1e-6);
    }
    @Test
    public void testGetGasInTank()
    {
        Car car = new Car(50.0);
        assertEquals(0.0, car.getGasInTank(), 1e-6);
        car.addGas(10.0);
        assertEquals(10.0, car.getGasInTank(), 1e-6);
    }
    @Test 
    public void testDrive()
    {
        Car car = new Car(50.0);
        car.addGas(10.0);
        car.drive(200.0);
        assertEquals(6.0, car.getGasInTank(), 1e-6);
        car.drive(25.0);
        assertEquals(5.5, car.getGasInTank(), 1e-6);
    }
    
    
}
