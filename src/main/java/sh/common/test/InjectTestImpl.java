package sh.common.test;

import javax.enterprise.context.Dependent;

@Dependent
public class InjectTestImpl implements InjectTest {

	/**
	 * ハロー
	 */
	@Override
	public void hello() {

		System.out.println("Hello, World!");

	}

}
