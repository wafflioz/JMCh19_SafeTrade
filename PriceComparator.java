/**
 * A price comparator for trade orders.
 */
public class PriceComparator implements java.util.Comparator<TradeOrder>
{

    // TODO complete class
    private boolean ascending = true;
    
    public PriceComparator() {

        ascending = true;
    }

    public PriceComparator(boolean asc) {
        ascending = asc;
    }

    public int compare(TradeOrder order1, TradeOrder order2) {
        if (order1.isMarket() && order2.isMarket()) {
            return 0;
        }

        if (order1.isMarket() && order2.isLimit()) {
            return -1;
        }

        if (order1.isLimit() && order2.isMarket()) {
            return 1;
        }

        int cents1 = (int) Math.round(order1.getPrice() * 100.0);
        int cents2 = (int) Math.round(order2.getPrice() * 100.0);

        if (ascending) {
            return cents1 - cents2;
        } else {
            return cents2 - cents1;
        }
    }

}
