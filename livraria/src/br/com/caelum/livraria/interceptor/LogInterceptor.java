package br.com.caelum.livraria.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		String methodFQN = context.getTarget().getClass().getName() + "." + context.getMethod().getName();
		long time = System.currentTimeMillis();
		Object obj = context.proceed();
		System.out.println(methodFQN + " ["+ (System.currentTimeMillis() - time) + " ms]");
		return obj;
	}
	
}
