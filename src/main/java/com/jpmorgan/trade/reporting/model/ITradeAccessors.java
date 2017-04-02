package com.jpmorgan.trade.reporting.model;

import java.time.LocalDate;

/**
 * A read only Interface for incoming trades
 *  
 * @author akumar
 *
 */
public interface ITradeAccessors {

	String getId();

	String getEntity();

	String getVerb();

	double getAgreedFx();

	String getCurrency();

	LocalDate getInstructionDate();

	LocalDate getSettlementDate();

	int getUntis();

	double getPrice();

}