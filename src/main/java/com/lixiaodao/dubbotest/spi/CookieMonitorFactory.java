package com.lixiaodao.dubbotest.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.monitor.Monitor;
import com.alibaba.dubbo.monitor.MonitorFactory;

/**
 * @author cookie.liya
 * @date   Jun 25, 2017
 */
public class CookieMonitorFactory implements MonitorFactory {

	@Override
	public Monitor getMonitor(URL url) {
		System.out.println("hello");
		return null;
	}
}


