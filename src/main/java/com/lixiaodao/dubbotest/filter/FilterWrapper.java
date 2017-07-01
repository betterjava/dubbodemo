package com.lixiaodao.dubbotest.filter;

import java.util.List;

import com.alibaba.dubbo.common.utils.CollectionUtils;

/**
 * @author cookie.liya
 * @date Jul 1, 2017
 */
public class FilterWrapper {

	public <T> Invoker<T> buildFilterChain(List<Filter> filters, final Invoker<T> invoker) {
		if (CollectionUtils.isEmpty(filters)) {
			return invoker;
		}
		Invoker<T> last = invoker;

		int size = filters.size();

		for (int i = size; i >= 0; i--) {
			final Filter filter = filters.get(i);
			final Invoker<T> next = last;

			last = new Invoker<T>() {

				@Override
				public Class<T> getInterface() {
					return invoker.getInterface();
				}

				@Override
				public Result invoke(Invocation invocation) throws InvokeException {
					return filter.invoke(next, invocation);
				}
			};
		}
		return last;
	}
}
