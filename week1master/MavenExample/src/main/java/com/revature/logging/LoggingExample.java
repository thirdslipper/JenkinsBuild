package com.revature.logging;

import org.apache.log4j.Logger;

public class LoggingExample {
	private static Logger log = Logger.getLogger(LoggingExample.class);
	public static void main(String[] args) {
		log.trace("This is a trace level message.");
		log.debug("This is a debug level message.");
		log.info("This is an info level message.");
		log.warn("This is a warn level message.");
		log.error("This is an error level message.");
		log.fatal("This is a fatal level message.");
	}
}
	