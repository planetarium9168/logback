package sh.common.util;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ログテストをちょっと便利にするUtil
 * 
 * @author sh
 */
public class LoggerUtil {

	/** デフォルトのライン文字 */
	private static String DEFAULT_OUTSTR = "-";

	/** デフォルトのライン文字数 */
	private static long DEFAULT_COUNT = 20;

	/**
	 * 目印のラインを出力
	 * 
	 * @param comment
	 */
	public static void line(Logger logger, String comment) {
		line(logger,  comment, DEFAULT_OUTSTR, DEFAULT_COUNT);
	}

	/**
	 * 目印のラインを出力
	 * 
	 * @param comment
	 * @param outstr
	 */
	public static void line(Logger logger, String comment, String outstr) {
		line(logger, comment, outstr, DEFAULT_COUNT);
	}

	/**
	 * 目印のラインを出力
	 * 
	 * @param comment
	 * @param outstr
	 * @param count
	 */
	public static void line(Logger logger, String comment, String outstr, long count) {
		StringBuilder sb = new StringBuilder();
		for (long n = 0; n < count; n++) {
			sb.append(outstr);
		}
		sb.append(comment);
		for (long n = 0; n < count; n++) {
			sb.append(outstr);
		}
		logger.info(sb.toString());
	}

	/**
	 * ログフォルダ「logs/*」を消す <br>
	 * ※自己責任で
	 */
	public static void deleteLogFolder() {
		File target = new File("./logs");
		if (target.exists() && target.isDirectory()) {
			removeFiles(target);
		}
	}

	private static void removeFiles(File file) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				removeFiles(f);
			}
		}
		file.delete();
	}

}
