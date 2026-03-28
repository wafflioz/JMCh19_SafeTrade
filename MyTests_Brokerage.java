public class MyTests_Brokerage {

    public static void test() {

        System.out.println("\n===== Brokerage Tests =====");
        // TODO - add tests for Brokerage class

        testBrokerageConstructor();
        testAddUserValid();
        testAddUserInvalidName();
        testAddUserInvalidPassword();
        testAddUserDuplicateName();
        testLoginValid();
        testLoginWithExistingMessages();
        testLoginUserNotFound();
        testLoginInvalidPassword();
        testLoginAlreadyLoggedIn();
        testLogout();
        testGetQuote();
        testPlaceOrder();
        testMultipleUsers();
        testLogoutNotLoggedIn();
        testBrokerageToString();
        testGetExchange();
    }
    
    private static void testBrokerageConstructor() {
        System.out.println("\nRunning testBrokerageConstructor...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        System.out.println("Expected traders map size: 0");
        System.out.println("Actual traders map size: " + brokerage.getTraders().size());
        System.out.println("Expected logged traders set size: 0");
        System.out.println("Actual logged traders set size: " + brokerage.getLoggedTraders().size());
        
        boolean passed = brokerage.getTraders().size() == 0 && 
                        brokerage.getLoggedTraders().size() == 0;
        System.out.println("Test passed: " + passed);
    }
    
    private static void testAddUserValid() {
        System.out.println("\nRunning testAddUserValid...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        int result = brokerage.addUser("trader1", "pass123");
        System.out.println("Expected return value: 0");
        System.out.println("Actual return value: " + result);
        System.out.println("Expected traders map size: 1");
        System.out.println("Actual traders map size: " + brokerage.getTraders().size());
        
        boolean passed = result == 0 && brokerage.getTraders().size() == 1;
        System.out.println("Test passed: " + passed);
    }
    
    private static void testAddUserInvalidName() {
        System.out.println("\nRunning testAddUserInvalidName...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        int result1 = brokerage.addUser("abc", "pass123");
        System.out.println("Expected return for 3-char name: -1");
        System.out.println("Actual return: " + result1);
        
        int result2 = brokerage.addUser("thisnameis11", "pass123");
        System.out.println("Expected return for 11-char name: -1");
        System.out.println("Actual return: " + result2);
        
        int result3 = brokerage.addUser("abcd", "pass");
        int result4 = brokerage.addUser("tencharnam", "pass");
        System.out.println("Expected return for 4-char name: 0");
        System.out.println("Actual return: " + result3);
        System.out.println("Expected return for 10-char name: 0");
        System.out.println("Actual return: " + result4);
        
        boolean passed = result1 == -1 && result2 == -1 && result3 == 0 && result4 == 0;
        System.out.println("Test passed: " + passed);
    }
    
    private static void testAddUserInvalidPassword() {
        System.out.println("\nRunning testAddUserInvalidPassword...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        int result1 = brokerage.addUser("trader1", "p");
        System.out.println("Expected return for 1-char password: -2");
        System.out.println("Actual return: " + result1);
        
        int result2 = brokerage.addUser("trader2", "password123");
        System.out.println("Expected return for 11-char password: -2");
        System.out.println("Actual return: " + result2);
        
        int result3 = brokerage.addUser("trader3", "pw");
        int result4 = brokerage.addUser("trader4", "password10");
        System.out.println("Expected return for 2-char password: 0");
        System.out.println("Actual return: " + result3);
        System.out.println("Expected return for 10-char password: 0");
        System.out.println("Actual return: " + result4);
        
        boolean passed = result1 == -2 && result2 == -2 && result3 == 0 && result4 == 0;
        System.out.println("Test passed: " + passed);
    }
    
    private static void testAddUserDuplicateName() {
        System.out.println("\nRunning testAddUserDuplicateName...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("trader1", "pass123");
        int result = brokerage.addUser("trader1", "pass456");
        
        System.out.println("Expected return for duplicate name: -3");
        System.out.println("Actual return: " + result);
        System.out.println("Expected traders map size: 1");
        System.out.println("Actual traders map size: " + brokerage.getTraders().size());
        
        boolean passed = result == -3 && brokerage.getTraders().size() == 1;
        System.out.println("Test passed: " + passed);
    }
    
    private static void testLoginValid() {
        System.out.println("\nRunning testLoginValid...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("trader1", "pass123");
        int result = brokerage.login("trader1", "pass123");
        
        System.out.println("Expected return value: 0");
        System.out.println("Actual return value: " + result);
        System.out.println("Expected logged traders size: 1");
        System.out.println("Actual logged traders size: " + brokerage.getLoggedTraders().size());
        
        Trader trader = brokerage.getTraders().get("trader1");
        System.out.println("Trader has welcome message: " + trader.hasMessages());
        
        boolean passed = result == 0 && brokerage.getLoggedTraders().size() == 1;
        System.out.println("Test passed: " + passed);
    }
    
    private static void testLoginWithExistingMessages() {
        System.out.println("\nRunning testLoginWithExistingMessages...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("trader1", "pass123");
        Trader trader = brokerage.getTraders().get("trader1");
        trader.receiveMessage("You have existing message");
        
        int result = brokerage.login("trader1", "pass123");
        
        System.out.println("Expected return: 0");
        System.out.println("Actual return: " + result);
        System.out.println("Expected logged traders size: 1");
        System.out.println("Actual logged traders size: " + brokerage.getLoggedTraders().size());
        System.out.println("Expected: Trader already had messages");
        System.out.println("Actual: " + trader.hasMessages());
        System.out.println("Test passed: " + (result == 0 && brokerage.getLoggedTraders().size() == 1));
    }
    
    private static void testLoginUserNotFound() {
        System.out.println("\nRunning testLoginUserNotFound...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        int result = brokerage.login("nonexistent", "password");
        
        System.out.println("Expected return value: -1");
        System.out.println("Actual return value: " + result);
        System.out.println("Test passed: " + (result == -1));
    }
    
    private static void testLoginInvalidPassword() {
        System.out.println("\nRunning testLoginInvalidPassword...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("trader1", "pass123");
        int result = brokerage.login("trader1", "wrongpass");
        
        System.out.println("Expected return value: -2");
        System.out.println("Actual return value: " + result);
        System.out.println("Expected logged traders size: 0");
        System.out.println("Actual logged traders size: " + brokerage.getLoggedTraders().size());
        System.out.println("Test passed: " + (result == -2));
    }
    
    private static void testLoginAlreadyLoggedIn() {
        System.out.println("\nRunning testLoginAlreadyLoggedIn...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("trader1", "pass123");
        brokerage.login("trader1", "pass123");
        int result = brokerage.login("trader1", "pass123");
        
        System.out.println("Expected return value: -3");
        System.out.println("Actual return value: " + result);
        System.out.println("Expected logged traders size: 1");
        System.out.println("Actual logged traders size: " + brokerage.getLoggedTraders().size());
        System.out.println("Test passed: " + (result == -3));
    }
    
    private static void testLogout() {
        System.out.println("\nRunning testLogout...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("trader1", "pass123");
        brokerage.login("trader1", "pass123");
        
        Trader trader = brokerage.getTraders().get("trader1");
        brokerage.logout(trader);
        
        System.out.println("Expected logged traders size after logout: 0");
        System.out.println("Actual logged traders size: " + brokerage.getLoggedTraders().size());
        System.out.println("Test passed: " + (brokerage.getLoggedTraders().size() == 0));
    }
    
    private static void testLogoutNotLoggedIn() {
        System.out.println("\nRunning testLogoutNotLoggedIn...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("trader1", "pass123");
        Trader trader = brokerage.getTraders().get("trader1");
        
        brokerage.logout(trader);
        
        System.out.println("Expected logged traders size: 0");
        System.out.println("Actual logged traders size: " + brokerage.getLoggedTraders().size());
        System.out.println("Test passed: true (no exception thrown)");
    }
    
    private static void testGetQuote() {
        System.out.println("\nRunning testGetQuote...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        exchange.listStock("GGGL", "Giggle.com", 10.00);
        brokerage.addUser("trader1", "pass123");
        
        Trader trader = brokerage.getTraders().get("trader1");
        brokerage.getQuote("GGGL", trader);
        
        System.out.println("Trader has messages: " + trader.hasMessages());
        System.out.println("Test passed: " + trader.hasMessages());
    }
    
    private static void testPlaceOrder() {
        System.out.println("\nRunning testPlaceOrder...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        exchange.listStock("GGGL", "Giggle.com", 10.00);
        brokerage.addUser("trader1", "pass123");
        
        Trader trader = brokerage.getTraders().get("trader1");
        TradeOrder order = new TradeOrder(trader, "GGGL", true, false, 100, 10.50);
        
        brokerage.placeOrder(order);
        
        Stock stock = exchange.getListedStocks().get("GGGL");
        System.out.println("Expected buy orders size: 1");
        System.out.println("Actual buy orders size: " + stock.getBuyOrders().size());
        System.out.println("Test passed: " + (stock.getBuyOrders().size() == 1));
    }
    
    private static void testMultipleUsers() {
        System.out.println("\nRunning testMultipleUsers...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        brokerage.addUser("alice", "pass1");
        brokerage.addUser("bob", "pass2");
        brokerage.addUser("charlie", "pass3");
        
        System.out.println("Expected traders map size: 3");
        System.out.println("Actual traders map size: " + brokerage.getTraders().size());
        
        brokerage.login("alice", "pass1");
        brokerage.login("bob", "pass2");
        
        System.out.println("Expected logged traders size: 2");
        System.out.println("Actual logged traders size: " + brokerage.getLoggedTraders().size());
        
        boolean passed = brokerage.getTraders().size() == 3 && 
                        brokerage.getLoggedTraders().size() == 2;
        System.out.println("Test passed: " + passed);
    }

    private static void testBrokerageToString() {
        System.out.println("\nRunning testBrokerageToString...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        String str = brokerage.toString();
        System.out.println("Brokerage toString: " + str);
        System.out.println("Contains class name: " + str.contains("Brokerage"));
    }

    private static void testGetExchange() {
        System.out.println("\nRunning testGetExchange...");
        StockExchange exchange = new StockExchange();
        Brokerage brokerage = new Brokerage(exchange);
        
        StockExchange retrieved = brokerage.getExchange();
        System.out.println("Retrieved exchange equals original: " + (retrieved == exchange));
        System.out.println("Test passed: " + (retrieved == exchange));
    }
}