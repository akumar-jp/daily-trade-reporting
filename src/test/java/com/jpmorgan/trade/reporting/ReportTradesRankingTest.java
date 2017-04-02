package com.jpmorgan.trade.reporting;

import com.jpmorgan.trade.reporting.model.IReportTradeStore;
import com.jpmorgan.trade.reporting.model.ReportTradesStore;
import com.jpmorgan.trade.simulation.InMemorySampleData;

import junit.framework.TestCase;
/**
 * Unit test to test ranking and overall trade count of trades after processing.
 * 
 * @author akumar
 *
 */
public class ReportTradesRankingTest extends TestCase {
	ITradesSubscriber tradeSubscriber;
	IReportTradeStore reportTrades;
	public ReportTradesRankingTest() {
	}
	
	public void setUp() {
		reportTrades = new ReportTradesStore();
		IWeekendHolidayService weekendHolidayService = new WeekendHolidayService();
		tradeSubscriber = new TradesSubscriber(weekendHolidayService, reportTrades, new MockLogger());
		InMemorySampleData.sampleTrades.forEach(trade->tradeSubscriber.handleTradeEvent(trade));
		
	}
	
	public void testBuyTradesCount(){
		assertEquals(reportTrades.getBuyTradesSize(), 5); 
	}
	
	
	public void testSellTradesCount(){
		assertEquals(reportTrades.getSellTradesSize(), 5); 
	}

	public void testBuyHightestValue(){
		assertEquals(reportTrades.getBuyTradesIterator().next().getTradeValue(),899910, .01); 
	}
	
	
	public void testSellHightestValue(){
		assertEquals(reportTrades.getSellTradesIterator().next().getTradeValue(),544320, .01); 
	}

}
