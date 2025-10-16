import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the ResaleShop and Computer classes.
 */

public class ShopTest {

    /* myComputer and myShop instances */
    Computer myComputer;
    ResaleShop myShop;

    /**
     * Setup method runs before each test.
     * Initializes myComputer and myShop objects.
     */
    @Before
    public void setup() { 
        myComputer = new Computer("2019 MacBook Pro", "Intel", 256, 32, "High Sierra", 2010, 1000);
        myShop = new ResaleShop(); 
    }

    /**
     * Checks if Computer constructor overrides initialized memory value
     */
    @Test 
    public void testConstructorMemory() {
        assertEquals(32, myComputer.memory);
    }

    /**
     * Checks if Computer constructor overrides initialized price value 
     */
    @Test 
    public void testConstructorPrice() {
        assertEquals(1000, myComputer.price);
    }

    /**
     * Checks if setOS method always updates OS to None rather than the newOS
     */
    @Test
    public void testNewOS() {
        myComputer.setOS("newOS");
        assertEquals("newOS", myComputer.operatingSystem);
    }

    /** 
     * Checks if ResaleShop constructor initializes with default computer
     */
    @Test
    public void testEmptyShop() { 
        assertTrue(myShop.inventory.isEmpty());
    }

    /**
     * Checks if buy() method creates a new computer and ignores parameter
     * @throws Exception if computer is already in inventory (required from buy() method)
     */
    @Test 
    public void testBuyAddsComputer() throws Exception {
        myShop.buy(myComputer);
        assertTrue(myShop.inventory.contains(myComputer));
    }

    /**
     * Checks if buy() method does not throw exception for duplicate computers 
     * @throws Exception if computer is already in inventory (required from buy() method)
     */
    @Test
    public void testDuplicateComputer() throws Exception { 
        int initialSize = myShop.inventory.size();
        myShop.buy(myComputer);
        myShop.buy(myComputer);
        assertNotEquals(initialSize+2, myShop.inventory.size()); // checks if duplicates were not added
    }

    /**
     * Checks if sell() method does not throw exception if computer not in inventory
     * @throws Exception if computer is not in inventory (required from sell() method)
     */
    @Test 
    public void testSellException() throws Exception{
        Computer randomComp = new Computer("HP", "AMD", 256, 8, "Windows 8", 2010, 300);
        int initialSize = myShop.inventory.size();
        myShop.sell(randomComp);
        assertNotEquals(initialSize, myShop.inventory.size());
    }

    /**
     * Checks if printInventory() goes out of bounds 
     */
    @Test 
    public void testPrintInventory() { 
        myShop.printInventory();
    }

    /**
     * Checks if refurbish() updates OS when given null (instead of "None")
     * @throws Exception if computer not in inventory (required from refurbish() method)
     */
    @Test
    public void testRefurbishOS() throws Exception{ 
        myShop.refurbish(myShop.inventory.get(0), null);
        assertSame(null, myShop.inventory.get(0).operatingSystem);
    }

    /**
     * refurbish() sets price of computers made between 2000-2012 as 2500 (overvalued)
     * @throws Exception if computer not in inventory (required from refurbish() method)
     */
    @Test
    public void testRefurbishPrice() throws Exception{ 
        myShop.inventory.add(myComputer); 
        myShop.refurbish(myComputer, null);
        assertEquals(250, myComputer.price);
    }
}
