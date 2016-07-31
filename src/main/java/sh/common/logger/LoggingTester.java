package sh.common.logger;

import sh.common.TestType;

/**
 * ログテストを定義するインタフェース
 * 
 * @author sh
 */
public interface LoggingTester {

	/** ログテスト */
	public void LogTest(TestType type);

}
