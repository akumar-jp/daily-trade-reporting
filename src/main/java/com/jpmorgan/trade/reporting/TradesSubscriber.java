package com.jpmorgan.trade.reporting;

import java.time.LocalDate;

import com.google.common.eventbus.Subscribe;
import com.jpmorgan.trade.reporting.model.IReportTradeStore;
import com.jpmorgan.trade.reporting.model.ITrade;
import com.jpmorgan.trade.reporting.model.Trade;
import com.jpmorgan.trade.reporting.util.ILogger;
import com.jpmorgan.trade.simulation.model.ITradeEvent;
/**
 * 
 * Listen to all incoming trades from External system
 * Process the trade for example calculate the trade value and actual settlement date if trade settlement date is holiday.
 * 
 * 
 * @author akumar
 *
 */
public class TradesSubscriber implements ITradesSubscriber {
	private final IWeekendHolidayService holidayService;
	private final  IReportTradeStore reportTrades;
	private final ILogger logger;
	
	
	public TradesSubscriber(IWeekendHolidayService holidayService,
							IReportTradeStore reportTrades,
							ILogger logger) {
		this.holidayService = holidayService;
		this.reportTrades = reportTrades;
		this.logger = logger;
	}

	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.ITradesSubscriber#handleTradeEvent(com.jpmorgan.trade.reporting.model.ITradeEvent)
	 */
	@Override
	@Subscribe
    public void handleTradeEvent(ITradeEvent tradeEvent) {
     logger.info("Received trade" + tradeEvent);
     
     /* USD amount of a trade = Price per unit * Units * Agreed Fx */
     final double tradeValue = calculateTradeValue(tradeEvent);
     final LocalDate actualSettlementDate = holidayService.nextBusinessDayIfHoliday(tradeEvent.getCurrency(), tradeEvent.getSettlementDate());
     
     ITrade trade = new Trade(tradeEvent, tradeValue, actualSettlementDate);
     reportTrades.addTrade(trade);
     logger.info("Process trade:" + tradeEvent.getId() + ", TradeValue:" + trade.getTradeValue() + ", Actual Settlement Date:" + trade.getActualSettlementDate());
    }

	private double calculateTradeValue(ITradeEvent event) {
		return event.getPrice() * event.getUntis() * event.getAgreedFx();
	}

}
