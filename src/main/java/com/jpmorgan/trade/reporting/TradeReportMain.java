package com.jpmorgan.trade.reporting;

import com.jpmorgan.trade.report.ConsoleTradeReport;
import com.jpmorgan.trade.report.ITradeReportWriter;
import com.jpmorgan.trade.reporting.model.IReportTradeStore;
import com.jpmorgan.trade.reporting.model.ReportTradesStore;
import com.jpmorgan.trade.reporting.util.ConsoleLogger;
import com.jpmorgan.trade.reporting.util.ILogger;
import com.jpmorgan.trade.simulation.IMessagingTradeBus;
import com.jpmorgan.trade.simulation.TradePublicationSystem;

/**
 * Main Class for the application 
 * 
 * It creates the initial required classes 
 * 
 * Usage: com.jpmorgan.trade.reporting.TradeReportMain
 *
 */
public class TradeReportMain 
{
    public static void main( String[] args )
    {
    	TradeReportMain app = new TradeReportMain();
    	app.start();
    
    }
    
    public void start() {
    	ILogger logger = new ConsoleLogger(ILogger.INFO_LOG_LEVEL);
    	
    	IMessagingTradeBus tradeBus = new TradePublicationSystem();
    	
    	
    	IWeekendHolidayService weekendHolidayService = new WeekendHolidayService();
    	IReportTradeStore reportTrades = new ReportTradesStore();
    	
    	/* Injecting the required services through constructor */
    	ITradesSubscriber tradeSubscriber = new TradesSubscriber(weekendHolidayService, reportTrades, logger);
    	tradeBus.registerTradeSubscriber(tradeSubscriber);
    
    	
    	/* Publish the trades to TradesSubscriber */
    	tradeBus.publishTrades();
    	
    	/* Prints the report on console*/
    	ITradeReportWriter tradeReport = new ConsoleTradeReport(logger);
    	tradeReport.writeBuyTrades(reportTrades.getBuyTradesIterator());
    	tradeReport.writeSellTrades(reportTrades.getSellTradesIterator());

    }
    
}
