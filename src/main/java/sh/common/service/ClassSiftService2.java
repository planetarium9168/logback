package sh.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sh.common.interceptor.SiftingInterceptorBinding;

@SiftingInterceptorBinding
public class ClassSiftService2 {
	
	private Logger LOGGER = LoggerFactory.getLogger(ClassSiftService2.class);
	
	public void log() {
		
		LOGGER.info("ClassSiftService2のログです。");
		LOGGER.debug("DEBUG");
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
		
	}
	
}
