package com.jpmorgan.trade.simulation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.trade.simulation.model.ITradeEvent;
import com.jpmorgan.trade.simulation.model.TradeEvent;

/**
 * Sample Data for the application.
 * 
 * @author akumar
 *
 */
public class InMemorySampleData {

	private static int i = 1;
	public static LocalDate thrusdayDate = LocalDate.of(2017, 3, 30);
	public static LocalDate fridayDate = LocalDate.of(2017, 3, 31);
	
	public static LocalDate saturdayDate = LocalDate.of(2017, 4, 1);
	public static LocalDate sundayDate = LocalDate.of(2017, 4, 2);
	public static LocalDate mondayDate = LocalDate.of(2017, 4, 3);
	
	public static List<ITradeEvent> sampleTrades;
	private final static String TRADE_PREFIX="A000000000"; 
	/* Weekday cases */
	public static ITradeEvent eurTradeEndingOnMonday = new TradeEvent(TRADE_PREFIX+i++, "Foo", "Buy", 1.07, "EUR",fridayDate , mondayDate, 1000, 101);
	public static ITradeEvent sgpTradeEndingOnMonday = new TradeEvent(TRADE_PREFIX+i++, "Bar", "Sell", .72, "SGP",fridayDate , mondayDate, 2000, 103);
	public static  ITradeEvent aedTradeEndingOnMonday = new TradeEvent(TRADE_PREFIX+i++, "IBM", "Buy", .27, "AED",thrusdayDate , mondayDate, 11000, 303);
	public static ITradeEvent sarTradeEndingOnMonday = new TradeEvent(TRADE_PREFIX+i++, "APPLE", "Sell", .27, "SAR",thrusdayDate , mondayDate, 1000, 503);
	
	/* Weekend cases */
	public static  ITradeEvent sarTradeEndingOnFriday = new TradeEvent(TRADE_PREFIX+i++, "Tesla", "Sell", .27, "SAR",thrusdayDate , fridayDate, 2000, 123);
	public static  ITradeEvent aedTradeEndingOnFriday = new TradeEvent(TRADE_PREFIX+i++, "Dell", "Buy", .27, "AED",thrusdayDate , fridayDate, 1000, 103);

	public static ITradeEvent sarTradeEndingOnSaturday = new TradeEvent(TRADE_PREFIX+i++, "Google", "Sell", .27, "SAR",thrusdayDate , saturdayDate, 1000, 123);
	public static ITradeEvent aedTradeEndingOnSaturday = new TradeEvent(TRADE_PREFIX+i++, "BPOil", "Buy", .27, "AED",thrusdayDate , saturdayDate, 1000, 109);

	public static ITradeEvent eurTradeEndingOnSaturday = new TradeEvent(TRADE_PREFIX+i++, "Goldman", "Buy", 1.07, "EUR",fridayDate , saturdayDate, 3000, 101);
	public static ITradeEvent sgpTradeEndingOnSunday = new TradeEvent(TRADE_PREFIX+i++, "INGBank", "Sell", .72, "SGP",fridayDate , sundayDate, 7000, 108);

	
	static {
		initialze();
	}
	
	private static void initialze() {
		sampleTrades = new ArrayList<>();
		sampleTrades.add(eurTradeEndingOnMonday );
		sampleTrades.add(sgpTradeEndingOnMonday );
		sampleTrades.add(aedTradeEndingOnMonday );
		sampleTrades.add(sarTradeEndingOnMonday );

		
		sampleTrades.add(sarTradeEndingOnFriday );
		sampleTrades.add(aedTradeEndingOnFriday );
		sampleTrades.add(sarTradeEndingOnSaturday );
		sampleTrades.add(aedTradeEndingOnSaturday );
		sampleTrades.add(eurTradeEndingOnSaturday );
		sampleTrades.add(sgpTradeEndingOnSunday );
	}
	
}
