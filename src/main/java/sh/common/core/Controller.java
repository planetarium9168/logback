package sh.common.core;

import sh.common.TestType;

/**
 * コントローラ
 * インジェクトテストも兼ねて
 * 
 * @author sh
 */
public interface Controller {

	public void execute(TestType type);

}
