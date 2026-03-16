
Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
Class StockExchange

java.lang.Object
  extended by StockExchange

public class StockExchange
extends java.lang.Object

Represents a stock exchange. A StockExchange keeps a HashMap of stocks, keyed by a stock symbol. It has methods to list a new stock, request a quote for a given stock symbol, and to place a specified trade order.

Constructor Summary
StockExchange()
          Constructs a new stock exchange object.
 
Method Summary
 java.lang.String 	getQuote(java.lang.String symbol)
          Returns a quote for a given stock.
 void 	listStock(java.lang.String symbol, java.lang.String name, double price)
          Adds a new stock with given parameters to the listed stocks.
 void 	placeOrder(TradeOrder order)
          Places a trade order by calling stock.placeOrder for the stock specified by the stock symbol in the trade order.
 
Methods inherited from class java.lang.Object
clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait
 

Constructor Detail
StockExchange

public StockExchange()

    Constructs a new stock exchange object. Initializes listed stocks to an empty map (a HashMap).

Method Detail
listStock

public void listStock(java.lang.String symbol,
                      java.lang.String name,
                      double price)

    Adds a new stock with given parameters to the listed stocks.

    Parameters:
        symbol - stock symbol.
        name - full company name.
        price - opening stock price.

getQuote

public java.lang.String getQuote(java.lang.String symbol)

    Returns a quote for a given stock. If the symbol (ex. XYZ) is not found in the exchange's list of stocks, the string that is returned should be "XYZ not found".

    Parameters:
        symbol - stock symbol. 
    Returns:
        a text message that contains the quote.

placeOrder

public void placeOrder(TradeOrder order)

    Places a trade order by calling stock.placeOrder for the stock specified by the stock symbol in the trade order. If the stock (ex. XYZ) is not found in the exchange's list of stocks, then the exchange sends a message to the trader with the message "XYZ not found".

    Parameters:
        order - a trading order to be placed with this stock exchange.

Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
