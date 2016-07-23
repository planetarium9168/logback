package sh.common.thread.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import sh.common.interceptor.SiftingInterceptorBinding;

public class UserB extends Thread {

	private Logger LOGGER = LoggerFactory.getLogger(UserB.class);
	
	private static String USER_NAME = UserB.class.getSimpleName();
	
	@Override
	public void run() {
		this.setName(USER_NAME);
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
