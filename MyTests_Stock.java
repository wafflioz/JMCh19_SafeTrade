import java.util.PriorityQueue;

public class MyTests_Stock {

    private static String symbol = "GGGL";
    private static String name = "Giggle.com";
    private static double price = 10.00;

    public static void test() {

        System.out.println("\n===== Stock Tests =====");
        // TODO - add tests for Stock class
        
        testStockConstructor();
        testStockGetQuote();
        testStockPlaceOrder();
        testStockExecuteOrders();
        testStockGetStockSymbol();
        testStockGetCompanyName();
        testStockGetLoPrice();
        testStockGetHiPrice();
        testStockGetLastPrice();
        testStockGetVolume();
        testStockGetBuyOrders();
        testStockGetSellOrders();

    }

    private static void testStockConstructor() {
        System.out.println("\nRunning testStockConstructor...");
        Stock stock = new Stock(symbol, name, price);
        System.out.println(stock.toString());

        System.out.println("Expected symbol: " + symbol);
        System.out.println("Actual symbol: " + stock.getStockSymbol());

        System.out.println("Expected name: " + name);
        System.out.println("Actual name: " + stock.getCompanyName());

        System.out.println("Expected lastPrice: " + price);
        System.out.println("Actual lastPrice: " + stock.getLastPrice());

        System.out.println("Expected loPrice: " + price);
        System.out.println("Actual loPrice: " + stock.getLoPrice());

        System.out.println("Expected hiPrice: " + price);
        System.out.println("Actual hiPrice: " + stock.getHiPrice());

        System.out.println("Expected volume: 0");
        System.out.println("Actual volume: " + stock.getVolume());

        System.out.println("Expected buyOrders empty: true");
        System.out.println("Actual buyOrders empty: " + stock.getBuyOrders().isEmpty());

        System.out.println("Expected sellOrders empty: true");
        System.out.println("Actual sellOrders empty: " + stock.getSellOrders().isEmpty());
    }

    private static void testStockGetQuote() {
        System.out.println("\nRunning testStockGetQuote...");
    }

    private static void testStockPlaceOrder() {
        System.out.println("\nRunning testStockPlaceOrder...");
        Stock stock = new Stock(symbol, name, price);
        
        TradeOrder buyOrder = new TradeOrder(null, symbol, true, false, 100, 10);
    }

    private static void testStockExecuteOrders() {
        System.out.println("\nRunning testStockExecuteOrders...");
    }

    private static void testStockGetStockSymbol() {
        System.out.println("\nRunning testStockGetStockSymbol...");
        Stock stock = new Stock(symbol, name, price);
        System.out.println("Expected: " + symbol);
        System.out.println("Actual: " + stock.getStockSymbol());
    }

    private static void testStockGetCompanyName() {
        System.out.println("\nRunning testStockGetCompanyName...");
        Stock stock = new Stock(symbol, name, price);
        System.out.println("Expected: " + name);
        System.out.println("Actual: " + stock.getCompanyName());
    }

    private static void testStockGetLoPrice() {
        System.out.println("\nRunning testStockGetLoPrice...");
        Stock stock = new Stock(symbol, name, price);
        System.out.println("Expected: " + price);
        System.out.println("Actual: " + stock.getLoPrice());
    }

    private static void testStockGetHiPrice() {
        System.out.println("\nRunning testStockGetHiPrice...");
        Stock stock = new Stock(symbol, name, price);
        System.out.println("Expected: " + price);
        System.out.println("Actual: " + stock.getHiPrice());
    }

    private static void testStockGetLastPrice() {
        System.out.println("\nRunning testStockGetLastPrice...");
        Stock stock = new Stock(symbol, name, price);
        System.out.println("Expected: " + price);
        System.out.println("Actual: " + stock.getLastPrice());
    }

    private static void testStockGetVolume() {
        System.out.println("\nRunning testStockGetVolume...");
        Stock stock = new Stock(symbol, name, price);
        System.out.println("Expected: " + 0);
        System.out.println("Actual: " + stock.getVolume());
    }

    private static void testStockGetBuyOrders() {
        System.out.println("\nRunning testStockGetBuyOrders...");
        Stock stock = new Stock(symbol, name, price);
        System.out.println("Expected buyOrders empty initially: true");
        System.out.println("Actual buyOrders empty initially: " + stock.getBuyOrders().isEmpty());
        
        TradeOrder buy = new TradeOrder(null, symbol, true, false, 50, 10);
        stock.placeOrder(buy);
        System.out.println("Expected buyOrders size after 1 order: " + 1);
        System.out.println("Actual buyOrders size after 1 order: " + stock.getBuyOrders().size());
    }

    private static void testStockGetSellOrders() {
        System.out.println("\nRunning testStockGetSellOrders...");
        Stock stock = new Stock(symbol, name, price);
        System.out.println("Expected sellOrders empty initially: true");
        System.out.println("Actual sellOrders empty initially: " + stock.getSellOrders().isEmpty());

        TradeOrder sell = new TradeOrder(null, symbol, false, false, 50, 100);
        stock.placeOrder(sell);
        System.out.println("Expected sellOrders size after 1 order: " + 1);
        System.out.println("Actual sellOrders size after 1 order: " + stock.getBuyOrders().size());
    }
}
