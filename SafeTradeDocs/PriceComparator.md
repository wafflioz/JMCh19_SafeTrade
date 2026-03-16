
Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
Class PriceComparator

java.lang.Object
  extended by PriceComparator

All Implemented Interfaces:
    java.util.Comparator<TradeOrder>

public class PriceComparator
extends java.lang.Object
implements java.util.Comparator<TradeOrder>

A price comparator for trade orders.

Constructor Summary
PriceComparator()
          Constructs a price comparator that compares two orders in ascending order.
PriceComparator(boolean asc)
          Constructs a price comparator that compares two orders in ascending or descending order.
 
Method Summary
 int 	compare(TradeOrder order1, TradeOrder order2)
          Compares two trade orders.
 
Methods inherited from class java.lang.Object
clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait
 
Methods inherited from interface java.util.Comparator
equals
 

Constructor Detail
PriceComparator

public PriceComparator()

    Constructs a price comparator that compares two orders in ascending order. Sets the private boolean ascending flag to true.

PriceComparator

public PriceComparator(boolean asc)

    Constructs a price comparator that compares two orders in ascending or descending order. The order of comparison depends on the value of a given parameter. Sets the private boolean ascending flag to asc.

    Parameters:
        asc - if true, make an ascending comparator; otherwise make a descending comparator.

Method Detail
compare

public int compare(TradeOrder order1,
                   TradeOrder order2)

    Compares two trade orders.

    Specified by:
        compare in interface java.util.Comparator<TradeOrder>

    Parameters:
        order1 - the first order
        order2 - the second order 
    Returns:
        0: if both orders are market orders.
        -1: if order1 is market and order2 is limit.
        1: if order1 is limit and order2 is market.
        The difference in prices in cents: if both order1 and order2 are limit orders. In this last case, the difference returned is cents1 - cents2 or cents2 - cents1, depending on whether this is an ascending or descending comparator (ascending is true or false). You will need to round your answer otherwise floating point conversion to integer can cause errors. Be careful when rounding positive and negative values...

Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
