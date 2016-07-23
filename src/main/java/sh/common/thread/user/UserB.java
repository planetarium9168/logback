package sh.common.thread.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import sh.common.interceptor.SiftingInterceptorBinding;

public class UserB extends Thread {

	private Logger LOGGER;
	
	private static String USER_NAME = UserB.class.getSimpleName();
	
	@Override
	public void run() {
		
		LOGGER = LoggerFactory.getLogger(UserB.class);
		setUserNameToMdc();
		outlog();
		
	}

	private void setUserNameToMdc() {
		// ThreadLocalへuser変数を設定
		MDC.put("user", USER_NAME);
	}
	
	private void outlog () {
		
		LOGGER.debug("I'm " + USER_NAME);
		
	}

}
