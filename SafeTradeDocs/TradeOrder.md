
Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
Class TradeOrder

java.lang.Object
  extended by TradeOrder

public class TradeOrder
extends java.lang.Object

Represents a buy or sell order for trading a given number of shares of a specified stock.

Constructor Summary
TradeOrder(Trader trader, java.lang.String symbol, boolean buyOrder, boolean marketOrder, int numShares, double price)
          Constructs a new TradeOrder for a given trader, stock symbol, a number of shares, and other parameters.
 
Method Summary
 double 	getPrice()
          Returns the price per share for this trade order (used by a limit order).
 int 	getShares()
          Returns the number of shares to be traded in this trade order.
 java.lang.String 	getSymbol()
          Returns the stock symbol for this trade order.
 Trader 	getTrader()
          Returns the trader for this trade order.
 boolean 	isBuy()
          Returns true if this is a buy order; otherwise returns false.
 boolean 	isLimit()
          Returns true if this is a limit order; otherwise returns false.
 boolean 	isMarket()
          Returns true if this is a market order; otherwise returns false.
 boolean 	isSell()
          Returns true if this is a sell order; otherwise returns false.
 void 	subtractShares(int shares)
          Subtracts a given number of shares from the total number of shares in this trade order.
 
Methods inherited from class java.lang.Object
clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait
 

Constructor Detail
TradeOrder

public TradeOrder(Trader trader,
                  java.lang.String symbol,
                  boolean buyOrder,
                  boolean marketOrder,
                  int numShares,
                  double price)

    Constructs a new TradeOrder for a given trader, stock symbol, a number of shares, and other parameters.

    Parameters:
        trader - a trader who placed this order.
        symbol - stock symbol.
        buyOrder - if true this is a buy order; otherwise this is a sell order.
        marketOrder - if true this is a market order; otherwise this is a limit order.
        numShares - the number of shares to be traded.
        price - the bid or ask price, if this is a limit order.

Method Detail
getTrader

public Trader getTrader()

    Returns the trader for this trade order.

    Returns:
        the trader who placed this trade order.

getSymbol

public java.lang.String getSymbol()

    Returns the stock symbol for this trade order.

    Returns:
        the stock symbol for this trade order.

isBuy

public boolean isBuy()

    Returns true if this is a buy order; otherwise returns false.

    Returns:
        true if this is a buy order; false otherwise.

isSell

public boolean isSell()

    Returns true if this is a sell order; otherwise returns false.

    Returns:
        true if this is a sell order; false otherwise.

isMarket

public boolean isMarket()

    Returns true if this is a market order; otherwise returns false.

    Returns:
        true if this is a market order; false otherwise.

isLimit

public boolean isLimit()

    Returns true if this is a limit order; otherwise returns false.

    Returns:
        true if this is a limit order; false otherwise.

getShares

public int getShares()

    Returns the number of shares to be traded in this trade order.

    Returns:
        the number of shares to be traded in this trade order.

getPrice

public double getPrice()

    Returns the price per share for this trade order (used by a limit order).

    Returns:
        the price per share for this trade order.

subtractShares

public void subtractShares(int shares)

    Subtracts a given number of shares from the total number of shares in this trade order.

    Parameters:
        shares - a number of shares to be subtracted. 
    Throws:
        java.lang.IllegalArgumentException - if shares is greater than the number of shares in this order.

Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
