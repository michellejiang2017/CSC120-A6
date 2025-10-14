import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the ResaleShop and Computer classes.
 * Tests are designed to detect bugs in the provided implementation.
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
     * Checks that Computer constructor overrides initialized memory value
     */
    @Test 
    public void testConstructorMemory() {
        assertNotEquals(32, myComputer.memory);
    }

    /**
     * Checks that Computer constructor overrides initialized price value 
     */
    @Test 
    public void testConstructorPrice() {
        assertNotEquals(1000, myComputer.price);
    }

    /**
     * Checks that setOS method always updates OS to None rather than the newOS
     */
    @Test
    public void testNewOS() {
        myComputer.setOS("newOS");
        assertNotEquals("newOS", myComputer.operatingSystem);
    }

    /** 
     * Checks that ResaleShop constructor initializes with default computer
     */
    @Test
    public void testEmptyShop() { 
        assertFalse(myShop.inventory.isEmpty());
    }

    /**
     * Checks that buy() method creates a new computer and ignores parameter
     * @throws Exception if computer is already in inventory (required from buy() method)
     */
    @Test 
    public void testBuyAddsComputer() throws Exception {
        myShop.buy(myComputer);
        assertFalse(myShop.inventory.contains(myComputer));
    }

    /**
     * Checks that buy() method does not throw exception for duplicate computers 
     * @throws Exception if computer is already in inventory (required from buy() method)
     */
    @Test
    public void testDuplicateComputer() throws Exception { 
        int initialSize = myShop.inventory.size();
        myShop.buy(myComputer);
        myShop.buy(myComputer);
        assertEquals(initialSize+2, myShop.inventory.size()); // checks that duplicates were not added
    }

    /**
     * Checks that sell() method does not throw exception if computer not in inventory
     * @throws Exception if computer is not in inventory (required from sell() method)
     */
    @Test 
    public void testSellException() throws Exception{
        Computer randomComp = new Computer("HP", "AMD", 256, 8, "Windows 8", 2010, 300);
        int initialSize = myShop.inventory.size();
        myShop.sell(randomComp);
        assertEquals(initialSize, myShop.inventory.size());
    }

    /**
     * Checks if printInventory() goes out of bounds 
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testPrintInventory() { 
        myShop.printInventory();
    }

    /**
     * Checks that refurbish() updates OS when given null (instead of "None")
     * @throws Exception if computer not in inventory (required from refurbish() method)
     */
    @Test
    public void testRefurbishOS() throws Exception{ 
        myShop.refurbish(myShop.inventory.get(0), null);
        assertNotSame(null, myShop.inventory.get(0).operatingSystem);
    }

    /**
     * refurbish() sets price of computers made between 2000-2012 as 2500 (overvalued)
     * @throws Exception if computer not in inventory (required from refurbish() method)
     */
    @Test
    public void testRefurbishPrice() throws Exception{ 
        myShop.inventory.add(myComputer); 
        myShop.refurbish(myComputer, null);
        assertNotEquals(250, myComputer.price);
    }
}
