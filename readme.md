Core backend classes: TradeOrder.java, PriceComparator.java, StockExchange.java, Stock.java, Brokerage.java, Trader.java
Test classes: MyTests_TradeOrder.java, MyTests_PriceComparator.java, MyTests_StockExchange.java, MyTests_Stock.java, MyTests_Brokerage.java (all have // TODO write tests)

Person 1:

Files: TradeOrder.java, PriceComparator.java, MyTests_TradeOrder.java, MyTests_PriceComparator.java
Why this split?: TradeOrder is a simple data class (constructor + accessors). PriceComparator is straightforward (implement Comparator interface with ascending/descending logic). Tests involve basic validation (e.g., constructor, getters, comparison). Low complexity, quick to complete.
Effort estimate: 2 simple classes + 2 test suites (~30-40% of total work).
Order: Implement TradeOrder first, then PriceComparator (it depends on TradeOrder), then tests.

Person 2:

Files: StockExchange.java, Brokerage.java, Trader.java, MyTests_StockExchange.java, MyTests_Brokerage.java
Why this split?: Trader is simple (name/password/mailbox). StockExchange and Brokerage are medium (manage collections, handle login/logout/registration). Tests cover collection operations and user management. Balanced with Person 1's load.
Effort estimate: 3 classes (1 simple, 2 medium) + 2 test suites (~30-40% of total work).
Order: Trader can be done early (simple). StockExchange and Brokerage after Stock is done (they depend on it indirectly via the system). Tests after implementations.

Person 3:

Files: Stock.java, MyTests_Stock.java
Why this split?: Stock is the most complex (priority queues for buy/sell orders, trade matching/execution, statistics updates, messaging). Its test suite will be the most involved (simulate orders, verify matching). This person has fewer files but the heaviest single task to balance overall effort.
Effort estimate: 1 hard class + 1 test suite (~30% of total work, but high intensity).
Order: Do after TradeOrder and PriceComparator are complete (dependencies). Test after implementation.