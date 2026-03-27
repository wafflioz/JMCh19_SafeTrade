import java.lang.reflect.*;
import java.util.*;

/**
 * Represents a stock trader.
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;
    private String screenName, password;
    private TraderView myView;
    private Queue<String> mailbox;

    public Trader(Brokerage brokerage, String name, String pswd)
    {
        this.brokerage = brokerage;
        this.screenName = name;
        this.password = pswd;
        this.mailbox = new LinkedList<String>();
    }

    public String getName()
    {
        return screenName;
    }

    public String getPassword()
    {
        return password;
    }

    public int compareTo(Trader other)
    {
        if (other == null)
            return 1;

        return screenName.compareToIgnoreCase(other.screenName);
    }

    public int hashCode() {
        return screenName.toLowerCase().hashCode();
    }

    public boolean equals(Object other)
    {
        Trader t = (Trader)other;
        return screenName.equalsIgnoreCase(t.screenName);
    }

    public void setView(TraderView view)
    {
        myView = view;
        while (myView != null && mailbox != null && !mailbox.isEmpty())
            myView.showMessage(mailbox.remove());
    }

    public boolean hasMessages()
    {
        return mailbox != null && !mailbox.isEmpty();
    }

    public void receiveMessage(String msg)
    {
        if (mailbox == null)
            mailbox = new LinkedList<String>();

        mailbox.add(msg);

        if (myView != null)
        {
            while (!mailbox.isEmpty())
                myView.showMessage(mailbox.remove());
        }
    }

    public void getQuote(String symbol)
    {
        try
        {
            java.lang.reflect.Method m = brokerage.getClass().getMethod("getQuote", String.class, Trader.class);
            m.invoke(brokerage, symbol, this);
        }
        catch (Exception e)
        {
        }
    }

    public void placeOrder(TradeOrder order)
    {
        try
        {
            java.lang.reflect.Method m = brokerage.getClass().getMethod("placeOrder", TradeOrder.class);
            m.invoke(brokerage, order);
        }
        catch (Exception e)
        {
        }
    }

    public void quit()
    {
        try
        {
            java.lang.reflect.Method m = brokerage.getClass().getMethod("logout", Trader.class);
            m.invoke(brokerage, this);
        }
        catch (Exception e)
        {
        }

        myView = null;
    }


    //
    // The following are for test purposes only
    //
    protected Queue<String> mailbox()
    {
        return mailbox;
    }
    
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
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
                if ( field.getType().getName().equals( "Brokerage" ) )
                    str += separator + field.getType().getName() + " "
                        + field.getName();
                else
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
