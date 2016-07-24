package sh.common.core;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sh.common.interceptor.SiftingInterceptorBinding;
import sh.common.logger.LoggingTester;
import sh.common.thread.user.UserA;
import sh.common.thread.user.UserB;
import sh.common.util.LoggerUtil;

public class ControllerImpl implements Controller {

	/** ロガー */
	private Logger LOGGER = LoggerFactory.getLogger(ControllerImpl.class);

	/** ログテスター */
	@Inject
	private LoggingTester loggingTester;

	@Override
	public void execute() {
		
		LoggerUtil.line(LOGGER, "logbackのテストを開始します。");

		loggingTester.normalLogTest();
		loggingTester.levelLogTest();
		loggingTester.loggerLogTest();
		loggingTester.siftUserLogTest();
		loggingTester.siftClassLogTest();

		LoggerUtil.line(LOGGER, "logbackのテストを終了します。");

	}

}
