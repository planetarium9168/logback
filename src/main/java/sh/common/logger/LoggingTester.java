package sh.common.logger;

/**
 * ログテストを定義するインタフェース
 * 
 * @author sh
 */
public interface LoggingTester {

	/** 通常のログ出力テスト */
	public void normalLogTest();

	/** ログレベルによる制限のテスト */
	public void levelLogTest();

	/** ロガーによる制限のテスト */
	public void loggerLogTest();

	/** 振り分けテスト(user) */
	public void siftUserLogTest();

	/** 振り分けテスト(class) */
	public void siftClassLogTest();

}
