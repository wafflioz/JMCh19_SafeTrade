Core backend classes: TradeOrder.java, PriceComparator.java, StockExchange.java, Stock.java, Brokerage.java, Trader.java
Test classes: MyTests_TradeOrder.java, MyTests_PriceComparator.java, MyTests_StockExchange.java, MyTests_Stock.java, MyTests_Brokerage.java (all have // TODO write tests)

## Sequential Work Split for 3 People

This project follows a strict sequential order to keep things clean and avoid dependencies issues. Each person completes their work fully before the next starts. Use Git to commit/push changes after each person finishes.

### Person 1 (Start Immediately - Foundations)
- **Files to Complete**: TradeOrder.java, PriceComparator.java, Trader.java, MyTests_TradeOrder.java, MyTests_PriceComparator.java
- **Why this split?**: These are the base classes with minimal dependencies. TradeOrder is a simple data class. PriceComparator builds directly on it. Trader is straightforward (name/password/mailbox management). Tests are basic validation.
- **Effort estimate**: 3 classes (2 simple, 1 basic) + 2 test suites (~40% of total work).
- **Order within Person 1**: Implement TradeOrder first, then PriceComparator (depends on TradeOrder), then Trader (independent), then tests for all.
- **When to start**: Now. Finish completely before Person 2 starts.

### Person 2 (Start After Person 1 Finishes - Core Logic)
- **Files to Complete**: Stock.java, MyTests_Stock.java
- **Why this split?**: Stock is the most complex class (priority queues, order matching, trade execution, statistics, messaging)—it requires PriceComparator to be done. The test suite will be the most involved (simulating orders and verifying matching).
- **Effort estimate**: 1 hard class + 1 test suite (~30% of total work, high intensity).
- **Order within Person 2**: Implement Stock first, then its tests.
- **When to start**: After Person 1 commits/pushes all their work.

### Person 3 (Start After Person 2 Finishes - Managers)
- **Files to Complete**: StockExchange.java, Brokerage.java, MyTests_StockExchange.java, MyTests_Brokerage.java
- **Why this split?**: These depend on Stock being complete (StockExchange forwards orders to Stocks, Brokerage uses StockExchange). They're medium complexity (managing collections for stocks/users, handling login/logout). Tests cover collection operations and user management.
- **Effort estimate**: 2 medium classes + 2 test suites (~30% of total work).
- **Order within Person 3**: StockExchange first (simpler), then Brokerage (uses StockExchange and Trader), then tests.
- **When to start**: After Person 2 commits/pushes all their work.

### Timeline and Process
- **Total time**: ~4-6 days (Person 1: 1-2 days, Person 2: 2-3 days, Person 3: 1-2 days), assuming ~4-6 hours/day per person.
- **Integration**: After each person finishes, run `make all` to check compilation. At the end, run `make test` and `make run` to validate.
- **Notes**: If bugs are found, the responsible person fixes them before handing off. No parallel work to keep it clean.