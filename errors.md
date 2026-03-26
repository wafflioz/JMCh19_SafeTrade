An error occurred while parsing the autoresult returned by the Autograder.

        
Error message: unexpected token at ': *** ["Makefile":"22": all] Error 1'

Autograder [Thu Mar 26 04:01:44 2026]: Received job APCS-A-25_JMCh19_SafeTrade_4_psaravanan573@student.fuhsd.org:98
Autograder [Thu Mar 26 04:01:46 2026]: Success: Autodriver returned normally
Autograder [Thu Mar 26 04:01:46 2026]: Here is the output from the autograder:
---
Autodriver: Job exited with status 2
# Autolab Checker v1.1
# Unpack student submissions and teacher test files
# Copy student files into tmp - and do not overwrite teacher test files already there
# Compilie various java files
# --- Coverage section ---
Running (Line) coverage for classes: Stock
PriceComparator
Brokerage
StockExchange
=================================
        RUNNING ALL TESTS        
=================================

Running testTradeOrderConstructor...
TradeOrder[Trader trader:null, java.lang.String symbol:GGGL, boolean buyOrder:true, boolean marketOrder:true, int numShares:123, double price:123.45]

Running testTradeOrderToString...
toString() returned: TradeOrder[Trader trader:null, java.lang.String symbol:GGGL, boolean buyOrder:true, boolean marketOrder:true, int numShares:123, double price:123.45]

Running testTradeOrderGetTrader...
Expected: null
Actual: null

Running testTradeOrderGetSymbol...
Expected: GGGL
Actual: GGGL

Running testTradeOrderIsBuy...
Expected: true
Actual: true

Running testTradeOrderIsSell...
Expected: false
Actual: false

Running testTradeOrderIsMarket...
Expected: true
Actual: true

Running testTradeOrderIsLimit...
Expected: false
Actual: false

Running testTradeOrderGetShares...
Expected: 123
Actual: 123

Running testTradeOrderGetPrice...
Expected: 123.45
Actual: 123.45

Running testTradeOrderSubtractShares...
After subtractShares(24)
Expected: 99
Actual: 99

===== Stock Tests =====

Running testStockConstructor...
Stock[java.text.DecimalFormat money:java.text.DecimalFormat@674dc, java.lang.String stockSymbol:GGGL, java.lang.String companyName:Giggle.com, double loPrice:10.0, double hiPrice:10.0, double lastPrice:10.0, int volume:0, java.util.PriorityQueue buyOrders:[], java.util.PriorityQueue sellOrders:[]]

Running testStockGetQuote...

Running testStockPlaceOrder...

Running testStockExecuteOrders...

Running testStockGetStockSymbol...
Expected: GGGL
Actual: GGGL

Running testStockGetCompanyName...
Expected: Giggle.com
Actual: Giggle.com

Running testStockGetLoPrice...
Expected: 10.0
Actual: 10.0

Running testStockGetHiPrice...
Expected: 10.0
Actual: 10.0

Running testStockGetLastPrice...
Expected: 10.0
Actual: 10.0

Running testStockGetVolume...
Expected: 0
Actual: 0

Running testStockGetBuyOrders...
Expected buyOrders empty initially: true
Actual buyOrders empty initially: true
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Trader.receiveMessage(String)" because the return value of "TradeOrder.getTrader()" is null
	at Stock.placeOrder(Stock.java:64)
	at MyTests_Stock.testStockGetBuyOrders(MyTests_Stock.java:96)
	at MyTests_Stock.test(MyTests_Stock.java:24)
	at MyTests.main(MyTests.java:10)
make: *** [Makefile:22: all] Error 1