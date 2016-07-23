package sh.common.core;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sh.common.interceptor.SiftingInterceptorBinding;
import sh.common.thread.user.UserA;
import sh.common.thread.user.UserB;

@SiftingInterceptorBinding
public class ControllerImpl implements Controller {
	
	/** ロガー */
	private Logger LOGGER = LoggerFactory.getLogger(ControllerImpl.class);
	
	@Inject
	private UserA userA;
	
	@Inject
	private UserB userB;
	
	@Override
	public void execute() {
		
		LOGGER.info("logbackのテストを開始します。");
		
		userA.start();
		
		userB.start();
		
		LOGGER.info("logbackのテストを終了します。");

	}

}
