
Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
Class Stock

java.lang.Object
  extended by Stock

public class Stock
extends java.lang.Object

Represents a stock in the SafeTrade project

Field Summary
static java.text.DecimalFormat 	money
           
 
Constructor Summary
Stock(java.lang.String symbol, java.lang.String name, double price)
          Constructs a new stock with a given symbol, company name, and starting price.
 
Method Summary
protected  void 	executeOrders()
          Executes as many pending orders as possible.
 java.lang.String 	getQuote()
          Returns a quote string for this stock.
 void 	placeOrder(TradeOrder order)
          Places a trading order for this stock.
 
Methods inherited from class java.lang.Object
clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait
 

Field Detail
money

public static java.text.DecimalFormat money

Constructor Detail
Stock

public Stock(java.lang.String symbol,
             java.lang.String name,
             double price)

    Constructs a new stock with a given symbol, company name, and starting price. Sets low price, high price, and last price to the same opening price. Sets "day" volume to zero. Initializes a priority qieue for sell orders to an empty PriorityQueue with a PriceComparator configured for comparing orders in ascending order; initializes a priority qieue for buy orders to an empty PriorityQueue with a PriceComparator configured for comparing orders in descending order.

    Parameters:
        symbol - the stock symbol.
        name - full company name.
        price - opening price for this stock.

Method Detail
getQuote

public java.lang.String getQuote()

    Returns a quote string for this stock. The quote includes: the company name for this stock; the stock symbol; last sale price; the lowest and highest day prices; the lowest price in a sell order (or "market") and the number of shares in it (or "none" if there are no sell orders); the highest price in a buy order (or "market") and the number of shares in it (or "none" if there are no buy orders). For example:

      Giggle.com (GGGL)
      Price: 10.00  hi: 10.00  lo: 10.00  vol: 0
      Ask: 12.75 size: 300  Bid: 12.00 size: 500

    Or:

      Giggle.com (GGGL)
      Price: 12.00  hi: 14.50  lo: 9.00  vol: 500
      Ask: none  Bid: 12.50 size: 200

    Returns:
        the quote for this stock.

placeOrder

public void placeOrder(TradeOrder order)

    Places a trading order for this stock. Adds the order to the appropriate priority queue depending on whether this is a buy or sell order. Notifies the trader who placed the order that the order has been placed, by sending a message to that trader. For example:

      New order:  Buy GGGL (Giggle.com)
      200 shares at $38.00

    Or, for market orders:

      New order:  Sell GGGL (Giggle.com)
      150 shares at market

    Executes pending orders by calling executeOrders.

    Parameters:
        order - a trading order to be placed.

executeOrders

protected void executeOrders()

    Executes as many pending orders as possible.

        Examines the top sell order and the top buy order in the respective priority queues.
            If both are limit orders and the buy order price is greater or equal to the sell order price, continue to step 2 to process the order (or a part of it) at the sell order price.
            If one order is limit and the other is market, continue to step 2 to process the order (or a part of it) at the limit order price
            If both orders are market, continue to step 2 to process the the order (or a part of it) at the last sale price.
            If none of the above (i.e. both were limit orders and the buy order price is less than the sell order price) then no orders can be executed. 
        Figures out how many shares can be traded, which is the smallest of the numbers of shares in the two orders.
        Subtracts the traded number of shares from each order; Removes each of the orders with 0 remaining shares from the respective queue.
        Updates the day's low price, high price, and volume.
        Sends a message to each of the two traders involved in the transaction. For example:

             You bought: 150 GGGL at 38.00 amt 5700.00

        Note: The dollar amounts should be formatted to two decimal places (eg. 12.40, not 12.4)

        Repeats steps 1-5 for as long as possible, that is as long as there is any movement in the buy / sell order queues. (The process gets stuck when the top buy order and sell order are both limit orders and the ask price is higher than the bid price.)

Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
