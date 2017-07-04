package com.lixiaodao.cookierpc;

import com.lixiaodao.cookierpc.invoke.Invocation;
import com.lixiaodao.cookierpc.invoke.RpcInvocation;

/**
 * @author cookie.liya
 * @date Jul 3, 2017
 */
public class RpcUrl implements Url {

	private String methodName;
	private Object[] params;
	private Class<?>[] paramTypes;

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public void setParamTypes(Class<?>[] paramTypes) {
		this.paramTypes = paramTypes;
	}

	@Override
	public Invocation getInvocation() {
		RpcInvocation invocation = new RpcInvocation();
		invocation.setMethodName(methodName);
		invocation.setParams(params);
		invocation.setParamTypes(paramTypes);
		return invocation;
	}

}
