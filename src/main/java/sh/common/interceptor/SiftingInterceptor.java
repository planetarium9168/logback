package sh.common.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

@Interceptor
@SiftingInterceptorBinding
public class SiftingInterceptor extends AbstractInterceptor {

	@Override
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {

		String c = MDC.get("class");

		if (StringUtils.isEmpty(c)) {
			return runAsMainClass(ctx);
		} else {
			return runAsSubClass(ctx);
		}
	}

	private Object runAsMainClass(InvocationContext ctx) throws Exception {

		MDC.put("class", ctx.getMethod().getDeclaringClass().getSimpleName());

		Object result = ctx.proceed();

		MDC.remove("class");

		return result;

	}

	private Object runAsSubClass(InvocationContext ctx) throws Exception {
		return ctx.proceed();
	}

}
