
/**
 * Vending Machine.
 * 
 * @author Felix Zheng
 * @version 1
 */
public class VendingMachine
{
    // instance variables - replace the example below with your own
    private int cans;
    private int tokens;
    
    public VendingMachine()
    {
        this.cans = 10;
        this.tokens = 0;
    }
    public VendingMachine(int cans)
    {
        this.cans = cans;
        this.tokens = 0;
    }

    /**
     * Method to buy a can of soda
     * 
     * @pre there are cans in the vending machines
     */
    public void vend()
    {
        this.tokens += 1;
        this.cans -= 1;
    }
    /**
     * Refill the vending machine and remove all tokens
     * 
     * @param int cans - the number of cans to add
     * @post tokens - set to 0 because they were removed 
     */
    public void refill(int cans)
    {
        this.cans += cans;
        this.tokens = 0;
    }
    /**
     * Gets the number of tokens in the vending machine
     */
    public int getTokens()
    {
        return this.tokens;
    }
    /**
     * Gets the number of cans in the vending machine
     * 
     */
    public int getCans()
    {
        return this.cans;
    }
}
