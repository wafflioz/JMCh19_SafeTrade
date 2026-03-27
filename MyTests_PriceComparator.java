public class MyTests_PriceComparator {

    private static String symbol = "GGGL";
    private static double lowPrice = 10.00;
    private static double highPrice = 20.00;

    public static void test() {

        System.out.println("\n===== PriceComparator Tests =====");
        // TODO - add tests for PriceComparator class
        testPriceComparatorDefaultConstructor();
        testPriceComparatorAscConstructor();
        testPriceComparatorDescConstructor();
        testPriceComparatorBothMarket();
        testPriceComparatorMarketLimit();
        testPriceComparatorLimitMarket();
        testPriceComparatorAscLoVsHi();
        testPriceComparatorAscHiVsLo();
        testPriceComparatorAscEqual();
        testPriceComparatorDescLoVsHi();
        testPriceComparatorDescHiVsLo();
        testPriceComparatorDescEqual();

    }

    private static void testPriceComparatorDefaultConstructor() {
        System.out.println("\nRunning testPriceComparatorDefaultConstructor...");
        PriceComparator pc = new PriceComparator();
        TradeOrder low = new TradeOrder(null, symbol, false, false, 100, lowPrice);
        TradeOrder high = new TradeOrder(null, symbol, false, false, 100, highPrice);
        System.out.println("Default constructor should be ascending");
        System.out.println("Expected: negative number");
        System.out.println("Actual: " + pc.compare(low, high));
    } 

    private static void testPriceComparatorAscConstructor() {
        System.out.println("\nRunning testPriceComparatorAscConstructor...");
        PriceComparator pc = new PriceComparator(true);
        TradeOrder low = new TradeOrder(null, symbol, false, false, 100, lowPrice);
        TradeOrder high = new TradeOrder(null, symbol, false, false, 100, highPrice);
        System.out.println("Constructor should be ascending");
        System.out.println("Expected: negative number");
        System.out.println("Actual: " + pc.compare(low, high));
    } 
    
    private static void testPriceComparatorDescConstructor() {
        System.out.println("\nRunning testPriceComparatorDescConstructor...");
        PriceComparator pc = new PriceComparator(false);
        TradeOrder low = new TradeOrder(null, symbol, false, false, 100, lowPrice);
        TradeOrder high = new TradeOrder(null, symbol, false, false, 100, highPrice);
        System.out.println("Constructor should be descending");
        System.out.println("Expected: positive number");
        System.out.println("Actual: " + pc.compare(low, high));
    } 

    private static void testPriceComparatorBothMarket() {
        System.out.println("\nRunning testPriceComparatorBothMarket...");
        PriceComparator pc = new PriceComparator(true);
        TradeOrder market1 = new TradeOrder(null, symbol, true, true, 100, 0);
        TradeOrder market2 = new TradeOrder(null, symbol, true, true, 100, 0);
        System.out.println("Expected: 0");
        System.out.println("Actual: " + pc.compare(market1, market2));
    } 

    private static void testPriceComparatorMarketLimit() {
        System.out.println("\nRunning testPriceComparatorMarketLimit...");
        PriceComparator pc = new PriceComparator(true);
        TradeOrder market1 = new TradeOrder(null, symbol, true, true, 100, 0);
        TradeOrder limit1 = new TradeOrder(null, symbol, true, false, 100, 0);
        System.out.println("Expected: -1");
        System.out.println("Actual: " + pc.compare(market1, limit1));
    } 

    private static void testPriceComparatorLimitMarket() {
        System.out.println("\nRunning testPriceComparatorLimitMarket...");
        PriceComparator pc = new PriceComparator(true);
        TradeOrder limit1 = new TradeOrder(null, symbol, true, false, 100, 0);
        TradeOrder market1 = new TradeOrder(null, symbol, true, true, 100, 0);
        System.out.println("Expected: 1");
        System.out.println("Actual: " + pc.compare(limit1, market1));
    } 
    
    private static void testPriceComparatorAscLoVsHi() {
        System.out.println("\nRunning testPriceComparatorAscLoVsHi...");
        PriceComparator pc = new PriceComparator(true);
        TradeOrder low = new TradeOrder(null, symbol, false, false, 100, lowPrice);
        TradeOrder high = new TradeOrder(null, symbol, false, false, 100, highPrice);
        System.out.println("Expected: negative number");
        System.out.println("Actual: " + pc.compare(low, high));
    } 

    private static void testPriceComparatorAscHiVsLo() {
        System.out.println("\nRunning testPriceComparatorAscHiVsLo...");
        PriceComparator pc = new PriceComparator(true);
        TradeOrder low = new TradeOrder(null, symbol, false, false, 100, lowPrice);
        TradeOrder high = new TradeOrder(null, symbol, false, false, 100, highPrice);
        System.out.println("Expected: positive number");
        System.out.println("Actual: " + pc.compare(high, low));
    } 

    private static void testPriceComparatorAscEqual() {
        System.out.println("\nRunning testPriceComparatorAscEqual...");
        PriceComparator pc = new PriceComparator(true);
        TradeOrder order1 = new TradeOrder(null, symbol, false, false, 100, lowPrice);
        TradeOrder order2 = new TradeOrder(null, symbol, false, false, 100, lowPrice);
        System.out.println("Expected: 0");
        System.out.println("Actual: " + pc.compare(order1, order2));
    } 

    private static void testPriceComparatorDescLoVsHi() {
        System.out.println("\nRunning testPriceComparatorDescLoVsHi...");
        PriceComparator pc = new PriceComparator(false);
        TradeOrder low = new TradeOrder(null, symbol, true, false, 100, lowPrice);
        TradeOrder high = new TradeOrder(null, symbol, true, false, 100, highPrice);
        System.out.println("Expected: positive number");
        System.out.println("Actual: " + pc.compare(low, high));
    } 
    
    private static void testPriceComparatorDescHiVsLo() {
        System.out.println("\nRunning testPriceComparatorDescHiVsLo...");
        PriceComparator pc = new PriceComparator(false);
        TradeOrder low = new TradeOrder(null, symbol, true, false, 100, lowPrice);
        TradeOrder high = new TradeOrder(null, symbol, true, false, 100, highPrice);
        System.out.println("Expected: negative number");
        System.out.println("Actual: " + pc.compare(high, low));
    } 

    private static void testPriceComparatorDescEqual() {
        System.out.println("\nRunning testPriceComparatorDescEqual...");
        PriceComparator pc = new PriceComparator(false);
        TradeOrder order1 = new TradeOrder(null, symbol, true, false, 100, highPrice);
        TradeOrder order2 = new TradeOrder(null, symbol, true, false, 100, highPrice);
        System.out.println("Expected: 0");
        System.out.println("Actual: " + pc.compare(order1, order2));
    } 
}
