package com.jpmorgan.trade.reporting;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;


/* 
 * A service class which holds the currency specific weekends and if a given date is holiday then returns the next business day.
 *  
 * AED Weekend: Friday-Saturday 	 	First Working Day- Sunday
 * SAR Weekend:Friday-Saturday 			First Working Day-Sunday
 * standard Saturday-Sunday 			First Working Day-Monday
 */
public class WeekendHolidayService implements IWeekendHolidayService {

	private final DayOfWeek gulfFirstWorkingDay;
	private final DayOfWeek restOfWorldFirstWorkingDay;
	
	public WeekendHolidayService() {
		gulfFirstWorkingDay = DayOfWeek.SUNDAY;
		restOfWorldFirstWorkingDay = DayOfWeek.MONDAY;
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.IWeekendHolidayService#nextBusinessDayIfHoliday(java.lang.String, java.time.LocalDate)
	 */
	@Override
	public LocalDate nextBusinessDayIfHoliday(String currency,LocalDate date) {
		if(isGulfCurrency(currency) && isFridayOrSaturday(date.getDayOfWeek())){
			return date.with(TemporalAdjusters.next(gulfFirstWorkingDay));
		}else if (!isGulfCurrency(currency) && isSaturdayOrSunday(date.getDayOfWeek())){
			return date.with(TemporalAdjusters.next(restOfWorldFirstWorkingDay));
		}else {
			return date;
		}
		
	}

	private boolean isGulfCurrency(String currency) {
		return "AED".equalsIgnoreCase(currency) || "SAR".equalsIgnoreCase(currency);
	}
	
	private boolean isFridayOrSaturday(DayOfWeek day) {
		return isFriday(day) || isSaturday(day);
		
	}
	
	private boolean isSaturdayOrSunday(DayOfWeek day) {
		return  isSaturday(day) || isSunday(day);
		
	}
	
	private boolean isFriday(DayOfWeek day){
		return day.equals(DayOfWeek.FRIDAY);
	}
	
	private boolean isSaturday(DayOfWeek day){
		return day.equals(DayOfWeek.SATURDAY);
	}
	
	private boolean isSunday(DayOfWeek day){
		return day.equals(DayOfWeek.SUNDAY);
	}
}
