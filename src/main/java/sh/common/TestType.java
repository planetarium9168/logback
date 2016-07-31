package sh.common;
import org.apache.commons.lang3.StringUtils;

public enum TestType {

	NORMAL("normal", "conf/normal", "通常の出力テストです。"),

	LEVEL("level", "conf/normal", "レベルによる制限のテストです。"),

	LOGGER("logger", "conf/normal", "ロガーによる制限のテストです。"),

	SIFT_USER("user", "conf/normal", "ユーザーによる振り分け テストです。"),

	SIFT_CLASS("class", "conf/normal", "クラスによる振り分け テストです。");

	private String name;

	private String path;
	
	private String dsc;

	private TestType(String name, String path, String dsc) {
		this.name = name;
		this.path = path;
		this.dsc = dsc;
	}

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
