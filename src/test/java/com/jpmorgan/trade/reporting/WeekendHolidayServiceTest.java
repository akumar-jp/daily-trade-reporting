package com.jpmorgan.trade.reporting;

import com.jpmorgan.trade.simulation.InMemorySampleData;

import junit.framework.TestCase;

/**
 * Unit test class to test weekend holidays as per the currency weekend holidays.
 * 
 * @author akumar
 *
 */
public class WeekendHolidayServiceTest extends TestCase {
	private IWeekendHolidayService weekendHolidayService; 
	
	public void setUp(){
		weekendHolidayService = new WeekendHolidayService();
	}
	
	public void testGulfWeekEndSettlement() {

		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("AED",InMemorySampleData.fridayDate).equals(InMemorySampleData.sundayDate));
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("AED",InMemorySampleData.saturdayDate).equals(InMemorySampleData.sundayDate));
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("SAR",InMemorySampleData.fridayDate).equals(InMemorySampleData.sundayDate));
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("SAR",InMemorySampleData.saturdayDate).equals(InMemorySampleData.sundayDate));
	}
	
	
	public void testRestOfWorlWeekEndSettlement() {

		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("EUR",InMemorySampleData.sundayDate).equals(InMemorySampleData.mondayDate));
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("SGP",InMemorySampleData.saturdayDate).equals(InMemorySampleData.mondayDate));
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("EUR",InMemorySampleData.sundayDate).equals(InMemorySampleData.mondayDate));
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("SGP",InMemorySampleData.saturdayDate).equals(InMemorySampleData.mondayDate));
	}

	public void testNormalSettlement() {

		
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("EUR",InMemorySampleData.fridayDate).equals(InMemorySampleData.fridayDate));
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("SGP",InMemorySampleData.fridayDate).equals(InMemorySampleData.fridayDate));
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("EUR",InMemorySampleData.fridayDate).equals(InMemorySampleData.fridayDate));
		assertTrue(weekendHolidayService.nextBusinessDayIfHoliday("SGP",InMemorySampleData.fridayDate).equals(InMemorySampleData.fridayDate));
	}

}
