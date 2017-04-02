package com.jpmorgan.trade.simulation.model;

import java.time.LocalDate;

/**
 * Encapsulates the Trade published by external system.
 * @author akumar
 *
 */
public final class TradeEvent implements ITradeEvent {
	private String id;
	private String entity;
	private String verb; 
	private double agreedFx;
	private String currency;
	private LocalDate  instructionDate;
	private LocalDate  settlementDate;
	private int untis;
	private double price;
	
	public TradeEvent(String id, String entity, String verb, double agreedFx, String currency,
			LocalDate instructionDate, LocalDate settlementDate, int untis, double price) {
		super();
		this.id = id;
		this.entity = entity;
		this.verb = verb;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.untis = untis;
		this.price = price;
		
		 
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#getId()
	 */
	@Override
	public String getId() {
		return id;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#getEntity()
	 */
	@Override
	public String getEntity() {
		return entity;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#setEntity(java.lang.String)
	 */
	@Override
	public void setEntity(String entity) {
		this.entity = entity;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#getVerb()
	 */
	@Override
	public String getVerb() {
		return verb;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#setVerb(String)
	 */
	@Override
	public void setVerb(String verb) {
		this.verb = verb;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#getAgreedFx()
	 */
	@Override
	public double getAgreedFx() {
		return agreedFx;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#setAgreedFx(double)
	 */
	@Override
	public void setAgreedFx(double agreedFx) {
		this.agreedFx = agreedFx;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#getCurrency()
	 */
	@Override
	public String getCurrency() {
		return currency;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#setCurrency(java.lang.String)
	 */
	@Override
	public void setCurrency(String currency) {
		this.currency = currency;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#getInstructionDate()
	 */
	@Override
	public LocalDate getInstructionDate() {
		return instructionDate;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#setInstructionDate(java.time.LocalDate)
	 */
	@Override
	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#getSettlementDate()
	 */
	@Override
	public LocalDate getSettlementDate() {
		return settlementDate;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#setSettlementDate(java.time.LocalDate)
	 */
	@Override
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#getUntis()
	 */
	@Override
	public int getUntis() {
		return untis;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#setUntis(int)
	 */
	@Override
	public void setUntis(int untis) {
		this.untis = untis;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#getPrice()
	 */
	@Override
	public double getPrice() {
		return price;
	}


	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.simulation.model.ITradeEvent#setPrice(double)
	 */
	@Override
	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "TradeEvent [id=" + id + ", entity=" + entity + ", verb=" + verb + ", agreedFx=" + agreedFx
				+ ", currency=" + currency + ", instructionDate=" + instructionDate + ", settlementDate="
				+ settlementDate + ", untis=" + untis + ", price=" + price + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(agreedFx);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instructionDate == null) ? 0 : instructionDate.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((settlementDate == null) ? 0 : settlementDate.hashCode());
		result = prime * result + untis;
		result = prime * result + ((verb == null) ? 0 : verb.hashCode());
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
		TradeEvent other = (TradeEvent) obj;
		if (Double.doubleToLongBits(agreedFx) != Double.doubleToLongBits(other.agreedFx))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instructionDate == null) {
			if (other.instructionDate != null)
				return false;
		} else if (!instructionDate.equals(other.instructionDate))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (settlementDate == null) {
			if (other.settlementDate != null)
				return false;
		} else if (!settlementDate.equals(other.settlementDate))
			return false;
		if (untis != other.untis)
			return false;
		if (verb == null) {
			if (other.verb != null)
				return false;
		} else if (!verb.equals(other.verb))
			return false;
		return true;
	}
	
	
	
	
}
