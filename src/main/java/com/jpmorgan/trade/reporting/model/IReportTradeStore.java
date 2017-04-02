package com.jpmorgan.trade.reporting.model;

import java.util.Iterator;

/**
 * Aggregate object which stores all the trades after initial processing.
 * @author akumar
 *
 */
public interface IReportTradeStore {

	/**
	 * Stores all the incoming processed Trades.
	 * @param trade
	 */
	void addTrade(ITrade trade);

	/**
	 * Returns the Iterator for Buy Trades
	 * @return Iterator for Buy trades
	 */
	Iterator<ITrade> getBuyTradesIterator();

	/**
	 * Returns the Iterator for Sell Trades
	 * @return Iterator for Sell trades
	 */
	Iterator<ITrade> getSellTradesIterator();

	/**
	 * Returns the number of Buy trades in the store
	 * @return count of Buy trades
	 */
	int getBuyTradesSize();

	/**
	 * Returns the number of Sell trades in the store
	 * @return count of Sell trades
	 */
	int getSellTradesSize();

}