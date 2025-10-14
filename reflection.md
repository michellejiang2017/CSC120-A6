Use this file to record your reflection on this assignment.

What are your initial impressions of how `Unit Testing` affects your programming?

Unit testing made it easier to keep track of the errors and bugs in the code and could help with separating the individual errors to better find exactly what was causing the error. 

**including a detailed description of the tests you implemented and what they do**

setup() sets up the variables myComputer and myShop which were used for the rest of the tests 

testConstructorMemory() shows that the computer constructor does not set up the computer with the passed-in memory of 32 and instead overrides it with 16 every time. 

testConstructorPrice() shows that the computer constructor does not set up the computer with the passed-in price of 1000 and instead overrides it with 0 every time. 

testNewOS() shows that the setOS() method always sets the computer OS as None and ignores the passed-in OS. 

testEmptyShop() shows that the resale shop does not initialize as an empty inventory. 

testBuyAddsComputer() shows that the buy() method doesn't add the passed-in computer and makes a new default computer instead. 

testDuplicateComputer() shows that the buy() method doesn't throw an error given a duplicate computer is added. 

testSellException() shows that the sell() method doesn't throw an error when passed-in computer is not in the inventory. 

testPrintInventory() shows that the printInventory() method goes out of bounds (becuase it uses <= instead of <)

testRefurbishOS() shows that the refurbish() method doesn't work correctly when given null as an OS and must take "None"

testRefurbishPrice() shows that the refurbish() method sets the price of computers made between 2000-2012 as 2500 when that price is higher than any of the newer computers. 

What worked, what didn't, what advice would you give someone taking this course in the future?

I had trouble testing the refurbish method, however, because the buy method had an error which did not allow me to add the proper computer into the inventory which mean that the computer I wanted to refurbish wasn't in the inventory--however I worked around it by just directly adding the computer I wanted into the inventory without using the buy method. 