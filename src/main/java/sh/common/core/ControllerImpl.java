package sh.common.core;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.inject.Inject;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

import sh.common.TestType;
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
	public void execute(TestType type) {

		LoggerUtil.line(LOGGER, "logbackのテストを開始します。[ type = " + type.getName() + " ]");
		loggingTester.LogTest(type);
		LoggerUtil.line(LOGGER, "logbackのテストを終了します。");

	}

}
