19.9 SafeTrade
Overview
In this lab, you will build a simplified electronic stock exchange called SafeTrade. When writing this class, you should refer to the SafeTrade Documentation for further details.
The system allows traders to:
Log in
Request stock quotes
Place buy and sell orders
Receive messages about completed trades
The program automatically matches buy and sell orders when prices are compatible.
You will implement the core backend classes using Java Collections.
What You Are Building
The SafeTrade system includes:
A StockExchange that manages all listed stocks
A Brokerage that manages traders
A Stock class that handles order matching
A Trader class representing each user
A TradeOrder data class
A PriceComparator class for priority queues
The GUI classes (LoginWindow, TraderWindow) and the SafeTrade launcher class are already provided.
How Stock Exchange Works
Order Types
Limit Order
Buy at a specific price (bid) or lower
Sell at a specific price (ask) or higher


Market Order
Buy at the lowest current ask price
Sell at the highest current bid price


Partial Orders
All orders are partial. If an order cannot be completely filled:
As many shares as possible are traded
The remaining shares stay active
Stock Quotes
A stock quote holds the following information:
Last sale price
Highest current bid (buy price)
Lowest current ask (sell price)
Day’s high price
Day’s low price
Total volume traded



Required Classes (You Write These)
TradeOrder (Write First)
A simple data class that stores:
Trader reference
Stock symbol
Buy or sell indicator
Number of shares
Market or limit indicator
Price (for limit orders)
Includes:
Constructor
Accessor methods

PriceComparator
Compares two TradeOrder objects by price.
You will need:
One ascending comparator (for sell orders)
One descending comparator (for buy orders)
Used by PriorityQueue.

StockExchange
Stores:
HashMap<String, Stock> (key = stock symbol)
Responsibilities:
Add new stocks
Forward trade orders to the correct stock
Provide quotes

Stock
Stores:
Stock symbol
Company name
Last sale price
Day high
Day low
Volume
PriorityQueue for buy orders
PriorityQueue for sell orders
Responsibilities:
Add new orders
Match buy and sell orders
Execute trades
Update statistics
Send messages to traders
This is the most complex class.

Brokerage
Stores:
TreeMap<String, Trader> for registered users
TreeSet<Trader> for logged-in users
Responsibilities:
Register users
Log in users
Log out users
Forward orders to StockExchange
Forward quote requests


Trader
Stores:
Trader name
Reference to Brokerage
Mailbox (Queue<String>)
Responsibilities:
Request quotes
Place orders
Receive messages
Display stored messages when logging in
Data Structures You Must Use
Purpose
Data Structure
Registered traders
Map => TreeMap<String, Trader>
Logged-in traders
Set => TreeSet<Trader>
Trader mailbox
Queue => LinkedList<String> 
Listed stocks
Map => HashMap<String, Stock>
Sell orders
Queue => PriorityQueue <TradeOrder> (lowest price first)
Buy orders
Queue => PriorityQueue <TradeOrder> (highest price first)


Implementation Order (Recommended)
TradeOrder
PriceComparator
Trader (basic version)
Stock (test separately)
StockExchange
Brokerage
Testing Requirements
You must test all of the code your group writes by utilizing MyTests.java, as in prior labs. You are to write code in myTests_Stock.java, MyTests_PriceComparator.java, MyTests_Brokerage.java and MyTests_StockExchange.java to achieve at least 90% line coverage on your code in the respective classes. (You do NOT need to have coverage on any main() methods in any of these files - these are not counted against you in the line coverage calculation). 
A MyTests_TradeOrder.java has been given to you as a sample.
Run the Makefile to create the covererage report by typing  ‘make’ in the Terminal. You can then view coverage results by using a browser to look at the coverage_report/index.html.
Here are some things to consider when testing your code:
Final Testing Checklist
Can users register?
Can users log in?
Do quotes display correctly?
Do buy/sell orders match correctly? Try out a variety of limit and market orders. Try out a variety of prices where orders are executed and not executed.
Are partial orders handled correctly?
Are messages saved if a trader logs out?
Are messages shown when logging back in?
