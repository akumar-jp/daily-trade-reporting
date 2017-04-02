package com.jpmorgan.trade.reporting.model;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
// TODO Auto-generated constructor stub
// Thought 1
//Map<String,SortedMap>
// Thought 2
// 2 different TreeSet for incoming and outgoing trades
//Thought3 
// process all the trades and then sort. 

import com.jpmorgan.trade.reporting.util.Constants;
/**
 * 
 * Aggregate object which cache all the sorte trades after initial processing.
 * Sorting is done as per trade value.
 * 
 * @author akumar
 *
 */
public class ReportTradesStore implements IReportTradeStore {

	private final Set<ITrade> buyTrades;
	private final Set<ITrade> sellTrades;

	public ReportTradesStore() {
		Comparator<ITrade> tradeValueComparator = tradeComparator();
		buyTrades = new TreeSet<>(tradeValueComparator);
		sellTrades = new TreeSet<>(tradeValueComparator);
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.model.IReportTradeStore#addTrade(com.jpmorgan.trade.reporting.model.model.ITrade)
	 */
	@Override
	public void addTrade(ITrade trade){
		if(trade.getVerb().equalsIgnoreCase(Constants.BUY_VERB)) {
			buyTrades.add(trade);
		}else {
			sellTrades.add(trade);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.model.IReportTradeStore#getBuyTradesIterator()
	 */
	@Override
	public Iterator<ITrade> getBuyTradesIterator() {
		return buyTrades.iterator();
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.model.IReportTradeStore#getSellTradesIterator()
	 */
	@Override
	public Iterator<ITrade> getSellTradesIterator() {
		return sellTrades.iterator();
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.model.IReportTradeStore#getBuyTradesSize()
	 */
	@Override
	public int getBuyTradesSize(){
		return buyTrades.size();
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.model.IReportTradeStore#getSellTradesSize()
	 */
	@Override
	public int getSellTradesSize(){
		return sellTrades.size();
	}

	/**
	 * Comparator for sorting the trades as per trade value.
	 * @return
	 */
	private static Comparator<ITrade> tradeComparator() {
		return Comparator.comparingDouble(ITrade::getTradeValue).reversed();
	}
	
	
}
