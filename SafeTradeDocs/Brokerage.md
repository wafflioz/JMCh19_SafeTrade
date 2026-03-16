
Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
Class Brokerage

java.lang.Object
  extended by Brokerage

All Implemented Interfaces:
    Login

public class Brokerage
extends java.lang.Object
implements Login

Represents a brokerage.

Constructor Summary
Brokerage(StockExchange exchange)
          Constructs new brokerage affiliated with a given stock exchange.
 
Method Summary
 int 	addUser(java.lang.String name, java.lang.String password)
          Tries to register a new trader with a given screen name and password.
 void 	getQuote(java.lang.String symbol, Trader trader)
          Requests a quote for a given stock from the stock exachange and passes it along to the trader by calling trader's receiveMessage method.
 int 	login(java.lang.String name, java.lang.String password)
          Tries to login a trader with a given screen name and password.
 void 	logout(Trader trader)
          Removes a specified trader from the set of logged-in traders.
 void 	placeOrder(TradeOrder order)
          Places an order at the stock exchange.
 
Methods inherited from class java.lang.Object
clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait
 

Constructor Detail
Brokerage

public Brokerage(StockExchange exchange)

    Constructs new brokerage affiliated with a given stock exchange. Initializes the map of traders to an empty map (a TreeMap), keyed by trader's name; initializes the set of active (logged-in) traders to an empty set (a TreeSet).

    Parameters:
        exchange - a stock exchange.

Method Detail
addUser

public int addUser(java.lang.String name,
                   java.lang.String password)

    Tries to register a new trader with a given screen name and password. If successful, creates a Trader object for this trader and adds this trader to the map of all traders (using the screen name as the key).

    Specified by:
        addUser in interface Login

    Parameters:
        name - the screen name of the trader.
        password - the password for the trader. 
    Returns:
        0 if successful, or an error code (a negative integer) if failed:
        -1 -- invalid screen name (must be 4-10 chars)
        -2 -- invalid password (must be 2-10 chars)
        -3 -- the screen name is already taken.

login

public int login(java.lang.String name,
                 java.lang.String password)

    Tries to login a trader with a given screen name and password. If no messages are waiting for the trader, sends a "Welcome to SafeTrade!" message to the trader. Adds the trader to the set of all logged-in traders.

    Specified by:
        login in interface Login

    Parameters:
        name - the screen name of the trader.
        password - the password for the trader. 
    Returns:
        0 if successful, or an error code (a negative integer) if failed:
        -1 -- screen name not found
        -2 -- invalid password
        -3 -- user is already logged in.

logout

public void logout(Trader trader)

    Removes a specified trader from the set of logged-in traders. The trader may be assumed to logged in already.

    Parameters:
        trader - the trader that logs out.

getQuote

public void getQuote(java.lang.String symbol,
                     Trader trader)

    Requests a quote for a given stock from the stock exachange and passes it along to the trader by calling trader's receiveMessage method.

    Parameters:
        symbol - the stock symbol.
        trader - the trader who requested a quote.

placeOrder

public void placeOrder(TradeOrder order)

    Places an order at the stock exchange.

    Parameters:
        order - an order to be placed at the stock exchange.

Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
