package com.jpmorgan.trade.simulation;

import static com.jpmorgan.trade.simulation.InMemorySampleData.sampleTrades;

import com.google.common.eventbus.EventBus;
import com.jpmorgan.trade.reporting.ITradesSubscriber;;

/**
 * Simulates external trade  publication system, which publish the in-memory trades to the application
 * @author akumar
 *
 */
public class TradePublicationSystem implements IMessagingTradeBus {
	private EventBus eventBus;
	public TradePublicationSystem() {
		eventBus = new EventBus();
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.report.simulation.ITradeBus#registerTradeSubscriber(com.jpmorgan.trade.reporting.TradesSubscriber)
	 */
	@Override
	public void registerTradeSubscriber(ITradesSubscriber tradeSubscriber) {
		eventBus.register(tradeSubscriber);
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.report.simulation.ITradeBus#publishTrades()
	 */
	@Override
	public void publishTrades(){
		sampleTrades.forEach(tradeEvent->eventBus.post(tradeEvent));
	}
}
