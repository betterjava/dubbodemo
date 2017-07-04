package com.lixiaodao.cookierpc.proxyfactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.lixiaodao.cookierpc.Url;
import com.lixiaodao.cookierpc.invoke.Invocation;
import com.lixiaodao.cookierpc.invoke.Invoker;
import com.lixiaodao.cookierpc.invoke.RpcInvocation;

/**
 * @author cookie.liya
 * @date   Jul 3, 2017
 */
public class JdkProxyFactory implements ProxyFactory {

	@Override
	public <T> T getproxy(final Invoker<T> invoker) {
		return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{invoker.getInterface()},new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				RpcInvocation invocation = new RpcInvocation();
				invocation.setMethodName(method.getName());
				invocation.setParams(args);
				invocation.setParamTypes(method.getParameterTypes());
				return invoker.invoke(invocation );
			}
		});
	}

	@Override
	public <T> Invoker<T> getInvoker(T proxy, Url url, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

}


