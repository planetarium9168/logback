package sh.common.test;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Dependent
public class InjectTestImpl implements InjectTest {
	
	@Inject
	private HelloThreadA a;
	
	@Inject
	private HelloThreadB b;
	
	private Logger LOGGER = LoggerFactory.getLogger(InjectTestImpl.class);
	
	/**
	 * ハロー
	 */
	@Override
	public void hello() {

		LOGGER.info("Hello, World!");
		
		a.start();
		
		b.start();
		
	}

}
