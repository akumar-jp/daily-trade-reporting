package com.jpmorgan.trade.reporting.util;

/**
 * Utility class to logs the messages on console
 * @author akumar
 *
 */
public class ConsoleLogger implements ILogger {
	private int logLevl;

	public ConsoleLogger(int levl) {
		this.logLevl = levl;
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.ILogger#info(java.lang.String)
	 */
	@Override
	public void info(String msg) {
		System.out.println(msg);
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.ILogger#debug(java.lang.String)
	 */
	@Override
	public void debug(String msg) {
		
		if(logLevl <= DEBUG_LOG_LEVEL) {
			/* To control the logging */
			System.out.println(msg);
		}
	}

	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.ILogger#trace(java.lang.String)
	 */
	@Override
	public void trace(String msg) {
		
		if(logLevl <= TRACE_LOG_LEVEL) {
			/* To control the logging */
			System.out.println(msg);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.trade.reporting.ILogger#error(java.lang.String)
	 */
	@Override
	public void error(String msg) {
		System.out.println(msg);
	}
}
