package br.com.caelum.livraria.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogLivros {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {		
		//System.out.println("Parâmetros [size=" + context.getParameters().length + "]: " + context.getParameters());
		Object obj = context.proceed();
		System.out.println("Retorno: " + obj);
		return obj;
	}
	
}
