import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;

/**
 * Represents a stock in the SafeTrade project
 */
public class Stock
{
    public static DecimalFormat money = new DecimalFormat( "0.00" );

    private String stockSymbol;
    private String companyName;
    private double loPrice, hiPrice, lastPrice;
    private int volume;
    private PriorityQueue<TradeOrder> buyOrders, sellOrders;

    // TODO complete class

    public Stock(String symbol, String name, double price) {
        stockSymbol = symbol;
        companyName = name;
        loPrice = price;
        hiPrice = price;
        lastPrice = price;
        volume = 0;
        sellOrders = new PriorityQueue<TradeOrder>(new PriceComparator(true));
        buyOrders = new PriorityQueue<TradeOrder>(new PriceComparator(false));
    }

    public String getQuote() {
        StringBuilder quote = new StringBuilder();
        quote.append(companyName).append(" (").append(stockSymbol).append(")\n");
        quote.append("Price: ").append(money.format(lastPrice)).append("  hi: ").append(money.format(hiPrice)).append("  lo: ").append(money.format(loPrice)).append("  vol: ").append(volume).append("\n");
        String askStr = "none";
        if (!sellOrders.isEmpty()) {
            TradeOrder topSell = sellOrders.peek();
            if (topSell.isLimit()) {
                askStr = money.format(topSell.getPrice()) + " size: " + topSell.getShares();
            } else {
                askStr = "market size: " + topSell.getShares();
            }
        }
        String bidStr = "none";
        if (!buyOrders.isEmpty()) {
            TradeOrder topBuy = buyOrders.peek();
            if (topBuy.isLimit()) {
                bidStr = money.format(topBuy.getPrice()) + " size: " + topBuy.getShares();
            } else {
                bidStr = "market size: " + topBuy.getShares();
            }
        }
        quote.append("Ask: ").append(askStr).append("  Bid: ").append(bidStr);
        return quote.toString();
    }

    public void placeOrder(TradeOrder order) {
        if (order.isBuy()) {
            buyOrders.add(order);
        } else {
            sellOrders.add(order);
        }
        String orderMsg = "New order:  " + (order.isBuy() ? "Buy" : "Sell") + " " + stockSymbol + " (" + companyName + ")\n" + order.getShares() + " shares at " + (order.isMarket() ? "market" : money.format(order.getPrice()));
        order.getTrader().receiveMessage(orderMsg);
        executeOrders();
    }

    protected void executeOrders() {
        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
            TradeOrder buy = buyOrders.peek();
            TradeOrder sell = sellOrders.peek();
            double execPrice = 0;
            boolean canExec = false;
            if (buy.isLimit() && sell.isLimit()) {
                if (buy.getPrice() >= sell.getPrice()) {
                    execPrice = sell.getPrice();
                    canExec = true;
                }
            } else if (buy.isMarket() && sell.isMarket()) {
                execPrice = lastPrice;
                canExec = true;
            } else {
                if (buy.isLimit()) {
                    execPrice = buy.getPrice();
                } else {
                    execPrice = sell.getPrice();
                }
                canExec = true;
            }
            if (!canExec) break;
            int sharesToTrade = Math.min(buy.getShares(), sell.getShares());
            buy.subtractShares(sharesToTrade);
            sell.subtractShares(sharesToTrade);
            if (buy.getShares() == 0) buyOrders.poll();
            if (sell.getShares() == 0) sellOrders.poll();
            loPrice = Math.min(loPrice, execPrice);
            hiPrice = Math.max(hiPrice, execPrice);
            lastPrice = execPrice;
            volume += sharesToTrade;
            String buyMsg = "You bought: " + sharesToTrade + " " + stockSymbol + " at " + money.format(execPrice) + " amt " + money.format(execPrice * sharesToTrade);
            String sellMsg = "You sold: " + sharesToTrade + " " + stockSymbol + " at " + money.format(execPrice) + " amt " + money.format(execPrice * sharesToTrade);
            buy.getTrader().receiveMessage(buyMsg);
            sell.getTrader().receiveMessage(sellMsg);
        }
    }
    //
    // The following are for test purposes only
    //
    
    protected String getStockSymbol()
    {
        return stockSymbol;
    }
    
    protected String getCompanyName()
    {
        return companyName;
    }
    
    protected double getLoPrice()
    {
        return loPrice;
    }
    
    protected double getHiPrice()
    {
        return hiPrice;
    }

    protected double getLastPrice()
    {
        return lastPrice;
    }
    
    protected int getVolume()
    {
        return volume;
    }

    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }
    
    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }
    
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
