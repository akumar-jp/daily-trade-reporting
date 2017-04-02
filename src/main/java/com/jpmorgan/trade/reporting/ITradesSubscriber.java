package com.jpmorgan.trade.reporting;

import com.jpmorgan.trade.simulation.model.ITradeEvent;

/**
 * Listen to all incoming trades from External system
 * Process the trade for example calculate the trade value and actual settlement date if trade settlement date is holiday.
 * @author akumar
 *
 */
public interface ITradesSubscriber {

	/** 
	 * Process an incoming trade from external system.
	 * @param tradeEvent incoming trade event from external system.
	 */
	void handleTradeEvent(ITradeEvent tradeEvent);
}