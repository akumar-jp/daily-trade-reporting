package com.jpmorgan.trade.simulation.model;

import java.time.LocalDate;

import com.jpmorgan.trade.reporting.model.ITradeAccessors;
/**
 * Trade event interface which is sent by external system
 * @author akumar
 *
 */
public interface ITradeEvent extends ITradeAccessors{

	void setId(String id);

	void setEntity(String entity);

	void setVerb(String verb);

	void setAgreedFx(double agreedFx);

	void setCurrency(String currency);

	void setInstructionDate(LocalDate instructionDate);

	void setSettlementDate(LocalDate settlementDate);

	void setUntis(int untis);

	void setPrice(double price);

}