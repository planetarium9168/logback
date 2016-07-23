package sh.common.interceptor;

import javax.interceptor.InvocationContext;

public abstract class AbstractInterceptor {
	
	abstract public Object intercept(InvocationContext ctx) throws Exception;
	
}
