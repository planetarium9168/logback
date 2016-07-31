package sh.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LimitedLoggerService2 {
	
	private Logger LOGGER = LoggerFactory.getLogger(LimitedLoggerService2.class);
	
	public void log () {
		LOGGER.warn(LimitedLoggerService2.class.getSimpleName() + "のログです。");
		LOGGER.debug("DEBUG");
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
	}
	
}
