package com.jpmorgan.trade.reporting.model;

import java.time.LocalDate;

/**
 * Interface for trade after processing the incoming trade event
 * @author akumar
 *
 */
public interface ITrade extends ITradeAccessors {

	/**
	 * Returns the trade value
	 * @return trade value
	 */
	double getTradeValue();
	
	/**
	 * Returns the actual settlement date if the input settlement date was holiday as per 
	 * trade currency
	 * @return trade actual settlement date
	 */
	LocalDate getActualSettlementDate();
	
}