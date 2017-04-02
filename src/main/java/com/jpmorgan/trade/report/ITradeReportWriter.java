package com.jpmorgan.trade.report;

import java.util.Iterator;

import com.jpmorgan.trade.reporting.model.ITrade;

/**
 * Interface to define the trade output
 * 
 * Specific format for exmple console, pdf, xml can be implemented using this interface 
 * 
 * 
 * @author akumar
 *
 */
public interface ITradeReportWriter {

	/**
	 * Iterates overs buy Trades and outputs the report
	 * @param iterator buy trades
	 */
	void writeBuyTrades(Iterator<ITrade> iterator);

	/**
	 * Iterates overs sell Trades and outputs the report
	 * @param iterator buy trades
	 */
	void writeSellTrades(Iterator<ITrade> iterator);

}