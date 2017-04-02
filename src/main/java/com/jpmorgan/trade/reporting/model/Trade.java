package com.jpmorgan.trade.reporting.model;

import java.time.LocalDate;

import com.jpmorgan.trade.simulation.model.ITradeEvent;

/**
 * An Immutable processed trade encapsulates the incoming trade event, trade value and  actual settlement date.
 * @author akumar
 *
 */
public final class Trade implements ITrade {

	final private ITradeAccessors tradeEvent;
	/* Calculated field */
	private double tradeValue;
	/* Calculated field */
	private LocalDate actualSettlementDate;

	public Trade(ITradeEvent tradeEvent,double tradeValue, LocalDate actualSettlementDate) {
		this.tradeEvent = tradeEvent;
		this.tradeValue = tradeValue;
		this.actualSettlementDate = actualSettlementDate;
	}

	@Override
	public double getTradeValue() {
		return tradeValue;
	}

	@Override
	public LocalDate getActualSettlementDate() {
		return actualSettlementDate;
	}
	
	@Override
	public String getId() {
		return tradeEvent.getId();
	}

	@Override
	public String getEntity() {
		return tradeEvent.getEntity();
	}

	@Override
	public String getVerb() {
		return tradeEvent.getVerb();
	}

	@Override
	public double getAgreedFx() {
		return tradeEvent.getAgreedFx();
	}

	@Override
	public String getCurrency() {
		return tradeEvent.getCurrency();
	}

	@Override
	public LocalDate getInstructionDate() {
		return tradeEvent.getInstructionDate();
	}

	@Override
	public LocalDate getSettlementDate() {
		return tradeEvent.getSettlementDate();
	}

	@Override
	public int getUntis() {
		return tradeEvent.getUntis();
	}

	@Override
	public double getPrice() {
		return tradeEvent.getPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualSettlementDate == null) ? 0 : actualSettlementDate.hashCode());
		result = prime * result + ((tradeEvent == null) ? 0 : tradeEvent.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tradeValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (actualSettlementDate == null) {
			if (other.actualSettlementDate != null)
				return false;
		} else if (!actualSettlementDate.equals(other.actualSettlementDate))
			return false;
		if (tradeEvent == null) {
			if (other.tradeEvent != null)
				return false;
		} else if (!tradeEvent.equals(other.tradeEvent))
			return false;
		if (Double.doubleToLongBits(tradeValue) != Double.doubleToLongBits(other.tradeValue))
			return false;
		return true;
	}

	
	

}
