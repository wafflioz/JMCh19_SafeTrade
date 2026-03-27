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
    } 
    
    private static void testPriceComparatorDescConstructor() {
        System.out.println("\nRunning testPriceComparatorDescConstructor...");
    } 

    private static void testPriceComparatorBothMarket() {
        System.out.println("\nRunning testPriceComparatorBothMarket...");
    } 

    private static void testPriceComparatorMarketLimit() {
        System.out.println("\nRunning testPriceComparatorMarketLimit...");
    } 

    private static void testPriceComparatorLimitMarket() {
        System.out.println("\nRunning testPriceComparatorLimitMarket...");
    } 
    
    private static void testPriceComparatorAscLoVsHi() {
        System.out.println("\nRunning testPriceComparatorAscLoVsHi...");
    } 

    private static void testPriceComparatorAscHiVsLo() {
        System.out.println("\nRunning testPriceComparatorAscHiVsLo...");
    } 

    private static void testPriceComparatorAscEqual() {
        System.out.println("\nRunning testPriceComparatorAscEqual...");
    } 

    private static void testPriceComparatorDescLoVsHi() {
        System.out.println("\nRunning testPriceComparatorDescLoVsHi...");
    } 
    
    private static void testPriceComparatorDescHiVsLo() {
        System.out.println("\nRunning testPriceComparatorDescHiVsLo...");
    } 

    private static void testPriceComparatorDescEqual() {
        System.out.println("\nRunning testPriceComparatorDescEqual...");
    } 
}
