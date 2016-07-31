package sh.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sh.common.interceptor.SiftingInterceptorBinding;

@SiftingInterceptorBinding
public class ClassSiftService1 {
	
	private Logger LOGGER = LoggerFactory.getLogger(ClassSiftService1.class);
	
	public void log() {
		
		LOGGER.info("ClassSiftService1のログです。");
		LOGGER.debug("DEBUG");
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
	}
	
}
