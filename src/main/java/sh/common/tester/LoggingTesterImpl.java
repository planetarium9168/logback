package sh.common.tester;

import java.util.Date;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.jboss.weld.bean.builtin.BeanManagerBean;
import org.jboss.weld.manager.BeanManagerImpl;
import org.jboss.weld.manager.BeanManagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sh.common.TestType;
import sh.common.service.ClassSiftService1;
import sh.common.service.ClassSiftService2;
import sh.common.service.LimitedLoggerService1;
import sh.common.service.LimitedLoggerService2;
import sh.common.thread.user.UserA;
import sh.common.thread.user.UserB;
import sh.common.util.LoggerUtil;

/**
 * ログテスト実装
 * 
 * @author sh
 */
public class LoggingTesterImpl implements LoggingTester {

	@Inject
	private ClassSiftService1 cservice1;

	@Inject
	private ClassSiftService2 cservice2;

	@Inject
	private LimitedLoggerService1 lservice1;

	@Inject
	private LimitedLoggerService2 lservice2;

	private Logger LOGGER = LoggerFactory.getLogger(LoggingTesterImpl.class);

	@Override
	public void LogTest(TestType type) {
		switch (type) {
		case NORMAL:
			normalLogTest();
			break;
		case LEVEL:
			levelLogTest();
			break;
		case LOGGER:
			loggerLogTest();
			break;
		case SIFT_USER:
			siftUserLogTest();
			break;
		case SIFT_CLASS:
			siftClassLogTest();
			break;
		}
	}

	public void normalLogTest() {
		LOGGER.info("通常のログ出力テストです。");
		LOGGER.info("全てのログレベルが記録されます。");
		LOGGER.debug("DEBUG");
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");
	}

	public void levelLogTest() {
		LOGGER.info("アペンダーのレベルを制限した出力テストです。");
		LOGGER.info("DEBUGレベルのログは記録されません。");
		LOGGER.info("※コンソールには出力されます。");
		LOGGER.debug("DEBUG");
		LOGGER.info("INFO");
		LOGGER.warn("WARN");
		LOGGER.error("ERROR");

	}

	public void loggerLogTest() {
		LOGGER.info("ロガー別のレベル制限テストです。");
		LOGGER.info("それぞれ設定されたログレベル以上のログのみ記録されます。");
		lservice1.log();
		lservice2.log();
	}

	public void siftUserLogTest() {
		LOGGER.info("ユーザー別の振り分けテストです。");
		LOGGER.info("Webアプリケーションであれば、リクエスト毎(スレッド)のログ出力が可能です。");
		UserA userA = new UserA();
		UserB userB = new UserB();

		userA.start();
		userB.start();

		Date now = new Date();
		int timeout = 1000;
		while (userA.isAlive() || userB.isAlive()) {
			if (diff(now, new Date()) > timeout) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}

	}

	public void siftClassLogTest() {
		LOGGER.info("クラス別の振り分けテストです。");
		LOGGER.info("※今回はインターセプターにより振り分け値を設定しています。");
		cservice1.log();
		cservice2.log();
	}

	private long diff(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			return Math.abs(date1.getTime() - date2.getTime());
		}
		return 0;
	}

}
