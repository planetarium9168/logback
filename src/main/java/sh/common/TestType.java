package sh.common;

import org.apache.commons.lang3.StringUtils;

/**
 * ログテストのタイプを定義するEnum
 * 
 * @author sh
 */
public enum TestType {

	NORMAL("normal", "conf/normal", "通常の出力テストです。"),

	LEVEL("level", "conf/level", "レベルによる制限のテストです。"),

	LOGGER("logger", "conf/logger", "ロガーによる制限のテストです。"),

	SIFT_USER("user", "conf/user", "ユーザーによる振り分け テストです。"),

	SIFT_CLASS("class", "conf/class", "クラスによる振り分け テストです。");

	/** 引数名 */
	private String name;

	/** logback.xmlが配置されているパス */
	private String path;

	/** 説明 */
	private String dsc;

	/**
	 * コンストラクタ
	 * 
	 * @param name
	 * @param path
	 * @param dsc
	 */
	private TestType(String name, String path, String dsc) {
		this.name = name;
		this.path = path;
		this.dsc = dsc;
	}

	/**
	 * 文字列よりEnumを取得します
	 * 
	 * @param name
	 * @return
	 */
	public static TestType forName(String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}

		for (TestType type : TestType.values()) {
			if (name.equals(type.getName())) {
				return type;
			}
		}
		return null;
	}

	public String getName() {
		return this.name;
	}

	public String getPath() {
		return this.path;
	}

	public String getDescription() {
		return this.dsc;
	}

}
