
Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
Class Trader

java.lang.Object
  extended by Trader

All Implemented Interfaces:
    java.lang.Comparable<Trader>

public class Trader
extends java.lang.Object
implements java.lang.Comparable<Trader>

Represents a stock trader.

Constructor Summary
Trader(Brokerage brokerage, java.lang.String name, java.lang.String pswd)
          Constructs a new trader, affiliated with a given brockerage, with a given screen name and password.
 
Method Summary
 int 	compareTo(Trader other)
          Compares this trader to another by comparing their screen names case blind.
 boolean 	equals(java.lang.Object other)
          Indicates whether some other trader is "equal to" this one, based on comparing their screen names case blind.
 java.lang.String 	getName()
          Returns the screen name for this trader.
 java.lang.String 	getPassword()
          Returns the password for this trader.
 void 	getQuote(java.lang.String symbol)
          Requests a quote for a given stock symbol from the brokerage by calling brokerage's getQuote.
 boolean 	hasMessages()
          Returns true if this trader has any messages in its mailbox.
 void 	setView(TraderView view)
          Sets a new TraderView for this trader and saves a reference to it in myView.
 void 	placeOrder(TradeOrder order)
          Places a given order with the brokerage by calling brokerage's placeOrder.
 void 	quit()
          Logs out this trader.
 void 	receiveMessage(java.lang.String msg)
          Adds msg to this trader's mailbox and displays all messages.
 
Methods inherited from class java.lang.Object
clone, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait
 

Constructor Detail
Trader

public Trader(Brokerage brokerage,
              java.lang.String name,
              java.lang.String pswd)

    Constructs a new trader, affiliated with a given brockerage, with a given screen name and password.

    Parameters:
        brokerage - the brokerage for this trader.
        name - user name.
        pswd - password.

Method Detail
getName

public java.lang.String getName()

    Returns the screen name for this trader.

    Returns:
        the screen name for this trader.

getPassword

public java.lang.String getPassword()

    Returns the password for this trader.

    Returns:
        the pasword for this trader.

compareTo

public int compareTo(Trader other)

    Compares this trader to another by comparing their screen names case blind.

    Specified by:
        compareTo in interface java.lang.Comparable<Trader>

    Parameters:
        other - the reference to a trader with which to compare. 
    Returns:
        the result of the comparison of this trader and other.

equals

public boolean equals(java.lang.Object other)

    Indicates whether some other trader is "equal to" this one, based on comparing their screen names case blind. This method will throw a ClassCastException if other is not an instance of Trader.

    Overrides:
        equals in class java.lang.Object

    Parameters:
        other - the reference to an object with which to compare. 
    Returns:
        true if this trader's screen name is the same as other's; false otherwise.

setView

public void setView(TraderView view)

    Sets a new TraderView for this trader and saves a reference to it in myView. Removes and displays all the messages, if any, from this trader's mailbox by calling myView.showMessage(msg) for each message.

hasMessages

public boolean hasMessages()

    Returns true if this trader has any messages in its mailbox.

    Returns:
        true if this trader has messages; false otherwise.

receiveMessage

public void receiveMessage(java.lang.String msg)

    Adds msg to this trader's mailbox and displays all messages. If this trader is logged in (myView is not null) removes and shows all the messages in the mailbox by calling myView.showMessage(msg) for each msg in the mailbox.

    Parameters:
        msg - a message to be added to this trader's mailbox.

getQuote

public void getQuote(java.lang.String symbol)

    Requests a quote for a given stock symbol from the brokerage by calling brokerage's getQuote.

    Parameters:
        symbol - a stock symbol for which a quote is requested.

placeOrder

public void placeOrder(TradeOrder order)

    Places a given order with the brokerage by calling brokerage's placeOrder.

    Parameters:
        order - a trading order to be placed.

quit

public void quit()

    Logs out this trader. Calls brokerage's logout for this trader. Sets myView to null (this method is called from a TraderWindow's window listener when the "close window" button is clicked).

Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
