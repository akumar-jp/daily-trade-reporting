package com.jpmorgan.trade.reporting;

import java.time.LocalDate;


/**
 * A service class which manages standard weekend holiday for specific currency
 * and returns the Next working if date is holiday as per given currency
 * 
 * @author akumar
 *
 */
public interface IWeekendHolidayService {

	/**
	 * Manages standard weekend holiday for specific currency
	 * and returns the Next working if date is holiday as per given currency
	 * 
	 * @param currency trade currency
	 * @param date settlement date
	 * @return if date is not holiday as per the given currency then returns the same else returns the
	 * next business day
	 */
	LocalDate nextBusinessDayIfHoliday(String currency, LocalDate date);

}