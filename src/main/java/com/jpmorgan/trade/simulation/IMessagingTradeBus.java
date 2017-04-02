package com.jpmorgan.trade.simulation;

import com.jpmorgan.trade.reporting.ITradesSubscriber;
/**
 * An interface which simulates the external Messaging system which
 * publish the trade events
 * @author akumar
 *
 */
public interface IMessagingTradeBus {

	/**
	 * A Trade Subscriber register for trade events
	 * @param tradeSubscriber a trade subscriber
	 */
	void registerTradeSubscriber(ITradesSubscriber tradeSubscriber);

	/**
	 * Publish the trades and all the subscriber would get the notification of trades. 
	 */
	void publishTrades();

}