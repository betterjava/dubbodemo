package com.lixiaodao.dubbotest.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author cookie.liya
 * @date Jun 25, 2017
 */
@SPI("run")
public interface Move {

	public void start();

	public void end();
	
	
	@Adaptive
	public void move(URL url);
}
