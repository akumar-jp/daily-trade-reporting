Important Classes
================
* Main Class and Usage: com.jpmorgan.trade.reporting.TradeReportMain
  If actual settlement date is different as per the currency convention then it is highlighted in the report with  * suffix for Settlement Date 
* ITradesSubscriber Listen to all the incoming trades from External system.
* ITradeReportWriter is the interface which can be implemented to format the report data. ConsoleTradeReport is the implementation of this interface which prints the report on console.
* IReportTradeStore is the interface for storing the processed trades and maintains the ranking of trade based on the trade direction and trade value
* IWeekendHolidayService is the service which encapsulates weekend holiday conventions as per different currency and return the next business day if a given settlement date is a holiday.
* Trade - Immutable Trade class encapsulates the processed trade
* Input trades to the assignment are simulated using TradePublicationSystem class and inputs trades kept in memory in INMemorySampleData class. 


Technical Highlights
======================
* Used Java 8 date time, Comparator and for loop therefore it would run in Java 8
* Used Gauva lib EventBus to simulate incoming trades from external application system.
* Unit test are included
* Dependency to the application are JUnit and Gauva

Design Patterns Implemented
==========================
* Used Delegate pattern in Trade class and delegates for all the trade attributes to ITradeEvent which are published by External Application system.
* Almost all the classes follow the Single Responsibility design principle specifically Report format and Report object holding the data are different.
* Encapsulation - Internal data structures of IReportTradeStore are not visible while formating the trade, it only exposes Iterator to write the trade objects.
* Subscriber pattern used for listening to incoming trade events
* Open for extension and closed for modification design principle implemented for weekendHoliday service in case currency based bank holidays need to be implemented then existing IWeekendHolidayService can decorated   with another dedicated bank holiday service  
* Interface segregation principle followed for ITradeEvent, ITradeAccessors and ITradeEvent interfaces



Assumptions
==========
 * Trade Units would not go beyond int range of 2billion AND 147 millions
 * Since it is a reporting application trade object cannot be modified except for the tradeValue and actualSettlementDate
	In ideal scenario event tradeValue and actualSettlementDate should also be part of Front office trade management system
	As mentioned as part of technical exercise this application calculates the tradeValue and actualSettlementDate
* As mentioned in specs "Amount in USD settled incoming everyday
						 Amount in USD settled outgoing everyday
						 Ranking of entities based on incoming and outgoing amount. Eg: If entity foo instructs the highest amount for a buy instruction, then foo is rank 1 for outgoing"
 - Understanding from the above is to sort buy and Sell trades separately based on the trade direction rather than sorting all the trades and printing buy and sell report in a group. 
* Since it is reporting application no validation or consistency rule applied on incoming trade values, it is assumed no exception handling is required including null failures.
  For example it is assumed all the values in the trade would be in order and currency and settlement date would not be null.
* It was assumed it is safe to hard code currency specific week-end conventions in the code and no future change expected otherwise design would be different to cope the same.

General Commentary 
=================
 * Naming convention of Trade Attribute is as used in the business and specs.
 * As mentioned in the specs, assignment is single threaded application so standard collection are used rather than concurrent.
 * Assignment has minimum level of logging for input trades and processed trades.

