package sh.common.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class HelloThreadB extends Thread {
	
	private Logger LOGGER = LoggerFactory.getLogger(HelloThreadB.class);
	
	@Override
	public void run() {
       MDC.put("user", "userB");
       LOGGER.info("I'm UserB.");
    }
	
}
