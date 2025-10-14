## Bug 1
Brief description: Computer constructor overrides initialized memory value
Failed unit test: testConstructorMemory()

## Bug 2
Brief description: Computer constructor overrides initialized price value 
Failed unit test: testConstructorPrice() 

## Bug 3
Brief description: setOS method always updates OS to None rather than the newOS
Failed unit test: testNewOS()

## Bug 4
Brief description: ResaleShop constructor initializes with default computer
Failed unit test: testEmptyShop()

## Bug 5
Brief description: buy() method creates a new computer and ignores parameter
Failed unit test: testBuyAddsComputer()

## Bug 6
Brief description: buy() method does not throw exception for duplicate computers 
Failed unit test: testDuplicateComputer()

## Bug 7
Brief description: sell() method does not throw exception if computer not in inventory
Failed unit test: testSellException() 

## Bug 8
Brief description: printInventory() goes out of bounds 
Failed unit test: testPrintInventory() 

## Bug 9
Brief description: refurbish() updates OS when given null (instead of "None")
Failed unit test: testRefurbishOS() 

## Bug 10
Brief description: refurbish() sets price of computers made between 2000-2012 as 2500 (overvalued)
Failed unit test: testRefurbishPrice()