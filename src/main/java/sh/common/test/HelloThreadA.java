package sh.common.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class HelloThreadA extends Thread {
	
	private Logger LOGGER = LoggerFactory.getLogger(HelloThreadA.class);
	
	@Override
	public void run() {
       MDC.put("user", "userA");
       LOGGER.info("I'm UserA.");
    }
	
}
