public class MyTests_StockExchange {

    public static void test() {

        System.out.println("\n===== StockExchange Tests =====");
        // TODO - add tests for StockExchange class
        
        testStockExchangeConstructor();
        testListStock();
        testGetQuoteStockExists();
        testGetQuoteStockNotFound();
        testPlaceOrderValidStock();
        testPlaceOrderInvalidStock();
        testMultipleStocks();
        testPlaceOrderWithMessage();
    }
    
    private static void testStockExchangeConstructor() {
        System.out.println("\nRunning testStockExchangeConstructor...");
        StockExchange exchange = new StockExchange();
        System.out.println("Expected: empty listed stocks map");
        System.out.println("Actual size: " + exchange.getListedStocks().size());
        System.out.println("Test passed: " + (exchange.getListedStocks().size() == 0));
    }
    
    private static void testListStock() {
        System.out.println("\nRunning testListStock...");
        StockExchange exchange = new StockExchange();
        
        exchange.listStock("GGGL", "Giggle.com", 10.00);
        System.out.println("Expected size after listing 1 stock: 1");
        System.out.println("Actual size: " + exchange.getListedStocks().size());
        System.out.println("Test passed: " + (exchange.getListedStocks().size() == 1));
        
        exchange.listStock("MSFT", "Microsoft", 250.00);
        exchange.listStock("AAPL", "Apple", 150.00);
        System.out.println("Expected size after listing 3 stocks: 3");
        System.out.println("Actual size: " + exchange.getListedStocks().size());
        System.out.println("Test passed: " + (exchange.getListedStocks().size() == 3));
    }
    
    private static void testGetQuoteStockExists() {
        System.out.println("\nRunning testGetQuoteStockExists...");
        StockExchange exchange = new StockExchange();
        exchange.listStock("GGGL", "Giggle.com", 10.00);
        
        String quote = exchange.getQuote("GGGL");
        System.out.println("Quote for GGGL:");
        System.out.println(quote);
        System.out.println("Test passed: " + quote.contains("Giggle.com"));
    }
    
    private static void testGetQuoteStockNotFound() {
        System.out.println("\nRunning testGetQuoteStockNotFound...");
        StockExchange exchange = new StockExchange();
        
        String quote = exchange.getQuote("XYZ");
        System.out.println("Expected: XYZ not found");
        System.out.println("Actual: " + quote);
        System.out.println("Test passed: " + quote.equals("XYZ not found"));
    }
    
    private static void testPlaceOrderValidStock() {
        System.out.println("\nRunning testPlaceOrderValidStock...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        exchange.listStock("GGGL", "Giggle.com", 10.00);
        
        brokerage.addUser("trader1", "pass123");
        Trader trader = brokerage.getTraders().get("trader1");
        
        TradeOrder order = new TradeOrder(trader, "GGGL", true, false, 100, 10.50);
        exchange.placeOrder(order);
        
        Stock stock = exchange.getListedStocks().get("GGGL");
        System.out.println("Expected buy orders size: 1");
        System.out.println("Actual buy orders size: " + stock.getBuyOrders().size());
        System.out.println("Test passed: " + (stock.getBuyOrders().size() == 1));
    }
    
    private static void testPlaceOrderInvalidStock() {
        System.out.println("\nRunning testPlaceOrderInvalidStock...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("trader1", "pass123");
        Trader trader = brokerage.getTraders().get("trader1");
        
        TradeOrder order = new TradeOrder(trader, "XYZ", true, false, 100, 10.50);
        exchange.placeOrder(order);
        
        System.out.println("Order placed for non-existent stock XYZ");
        System.out.println("Trader should receive 'XYZ not found' message");
        System.out.println("Trader has messages: " + trader.hasMessages());
        System.out.println("Test passed: true (no exception thrown)");
    }
    
    private static void testPlaceOrderWithMessage() {
        System.out.println("\nRunning testPlaceOrderWithMessage...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("trader1", "pass123");
        Trader trader = brokerage.getTraders().get("trader1");
        
        TradeOrder order = new TradeOrder(trader, "FAKE", true, false, 100, 10.50);
        exchange.placeOrder(order);
        
        System.out.println("Expected: Trader receives 'FAKE not found' message");
        System.out.println("Trader has messages: " + trader.hasMessages());
        System.out.println("Test passed: " + trader.hasMessages());
    }
    
    private static void testMultipleStocks() {
        System.out.println("\nRunning testMultipleStocks...");
        StockExchange exchange = new StockExchange();
        
        exchange.listStock("GGGL", "Giggle.com", 10.00);
        exchange.listStock("MSFT", "Microsoft", 250.00);
        exchange.listStock("AAPL", "Apple", 150.00);
        
        String quote1 = exchange.getQuote("GGGL");
        String quote2 = exchange.getQuote("MSFT");
        String quote3 = exchange.getQuote("AAPL");
        
        System.out.println("GGGL quote contains 'Giggle.com': " + quote1.contains("Giggle.com"));
        System.out.println("MSFT quote contains 'Microsoft': " + quote2.contains("Microsoft"));
        System.out.println("AAPL quote contains 'Apple': " + quote3.contains("Apple"));
        
        boolean allCorrect = quote1.contains("Giggle.com") && 
                           quote2.contains("Microsoft") && 
                           quote3.contains("Apple");
        System.out.println("Test passed: " + allCorrect);
    }
}