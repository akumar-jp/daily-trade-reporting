package com.jpmorgan.trade.reporting.util;
/**
 * A simple interface to wrap a Logger functionality
 * @author a.kumar
 *
 */
public interface ILogger {

	int TRACE_LOG_LEVEL = 0;
	int DEBUG_LOG_LEVEL = 1;
	int INFO_LOG_LEVEL = 2;

	/**
	 * Logs the message at info level
	 * @param msg
	 */
	void info(String msg);

	/**
	 * Logs the message at debug level
	 * @param msg
	 */
	void debug(String msg);

	/**
	 * Logs the message at trace level
	 * @param msg
	 */
	void trace(String msg);

	/**
	 * Logs the message at error level
	 * @param msg
	 */
	void error(String msg);

}