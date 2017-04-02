package com.jpmorgan.trade.report;

import java.util.Iterator;

import com.jpmorgan.trade.reporting.model.ITrade;
import com.jpmorgan.trade.reporting.util.ILogger;
/**
 * Outputs the Trade report on Console
 * 
 * 
 * @author akumar
 *
 */
public class ConsoleTradeReport implements ITradeReportWriter {

	private final ILogger logger;

	public ConsoleTradeReport(ILogger logger) {
		this.logger = logger;
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.report.ITradeReportWriter#writeBuyTrades(java.util.Iterator)
	 */
	@Override
	public void writeBuyTrades(Iterator<ITrade> iterator) {
		logger.info("Buy Trades");
		logger.info("***************************");
		renderTrades(iterator);
	}

	private void renderTrades(Iterator<ITrade> iterator) {
		logger.info("Entity"+"\t\t"+
		           "Instruction Date"+"\t"+
		           "Settlement Date"+"    "+
		           "Currency"+"\t\t"+
		           "AgreedFx"+"\t"+
		           "Price" +"\t\t"+
		           "Untis" +"\t\t"+
		           "Verb"  +"\t\t"+
		           "TradeValue");
		
		
		while(iterator.hasNext()) {
			ITrade trade = iterator.next();
			logger.info(trade.getEntity()+"\t\t"+
			           trade.getInstructionDate()+"\t\t"+
			           getSettlementTradeString(trade) + "\t\t"+
			           trade.getCurrency()+"\t\t"+
			           trade.getAgreedFx()+"\t\t"+
			           trade.getPrice() +"\t\t"+
			           trade.getUntis() +"\t\t"+
			           trade.getVerb()  +"\t\t"+
			           Math.round(trade.getTradeValue()));
			
		}
	}
	
	private String getSettlementTradeString(ITrade trade){
		String date = String.valueOf(trade.getActualSettlementDate());
		if(!trade.getActualSettlementDate().equals(trade.getSettlementDate())){
			date +="*";
		}
		return date;
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.report.ITradeReportWriter#writeSellTrades(java.util.Iterator)
	 */
	@Override
	public void writeSellTrades(Iterator<ITrade> iterator) {
		logger.info("Sell Trades");
		logger.info("********************************************************");
		renderTrades(iterator);
		
	}
}
