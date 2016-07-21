package sh.common.core;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;

import sh.common.core.Main;
import sh.common.test.InjectTest;

public class Main {
	
	/** Main */
	private static Main main;
	
	/** Injectテスト */
	@Inject
	private InjectTest injectTest;
	
	/**
	 * 起動メソッド
	 * 
	 * @param args 起動引数
	 */
	public static void main(String[] args) {
		// 実行
		getInstance().run();
	}
	
	/**
	 * Mainクラス取得メソッド
	 * 
	 * @return 
	 */
	private static Main getInstance() {
		if (main == null) {
			Weld weld = new Weld();
			main = weld.initialize().select(Main.class).get();
			weld.shutdown();
		}
		return main;
	}
	
	/**
	 * 実行
	 */
	private void run () {
		injectTest.hello();
	}

}
