package com.lixiaodao.cookierpc.invoke;

/**
 * @author cookie.liya
 * @date Jul 3, 2017
 */
public class RpcInvocation implements Invocation {

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
	public String getMethodName() {
		return methodName;
	}

	@Override
	public Object[] getParams() {
		return params;
	}

	@Override
	public Class<?>[] getParamTypes() {
		return paramTypes;
	}

}
