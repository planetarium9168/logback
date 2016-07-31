package sh.common.core;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.inject.Inject;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jboss.weld.environment.se.Weld;
import org.slf4j.Logger;

import sh.common.TestType;
import sh.common.core.Main;
import sh.common.util.LoggerUtil;

public class Main {

	/** Main */
	private static Main main;

	/** コントローラ */
	@Inject
	private Controller controller;

	/**
	 * 起動メソッド
	 * 
	 * @param args
	 *            起動引数
	 */
	public static void main(String[] args) {
		// ログフォルダ削除
		LoggerUtil.deleteLogFolder();

		// テストタイプ取得
		TestType type = convert(args);

		if (type == null) {
			System.out.println("引数を指定して下さい。");
			for (TestType t : TestType.values()) {
				System.out.println(t.getName() + "\t: " + t.getDescription());
			}
			return;
		}

		// パス追加
		setClassPath(type);

		// 実行
		getInstance().run(type);

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
	private void run(TestType type) {
		controller.execute(type);
	}

	/**
	 * TestTypeに定義されたlogback.xml配置ディレクトリをクラスパスに追加します。
	 * 
	 * @param type
	 */
	private static void setClassPath(TestType type) {
		if (type != null && !StringUtils.isEmpty(type.getPath())) {
			try {
				ClassLoader cl = Thread.currentThread().getContextClassLoader();
				URL url = cl.getResource(type.getPath());
				addClassPath(cl, new File(url.getPath()).getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 引数からTestTypeを取得します
	 * 
	 * @param args
	 * @return
	 */
	private static TestType convert(String[] args) {
		if (CollectionUtils.sizeIsEmpty(args)) {
			return null;
		}
		return TestType.forName(args[0]);
	}

	private static void addClassPath(ClassLoader classLoader, String path)
			throws ReflectiveOperationException, MalformedURLException {
		if (classLoader instanceof URLClassLoader) {
			// URLClassLoaderであることが前提
			Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
			method.setAccessible(true);
			// ロードするURLを追加する
			method.invoke(classLoader, new File(path).toURI().toURL());
		}
	}

}
