package com.atp.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @Description 服务上下文环境帮助类
 * @author  Yang Yun Long
 * @Date 2017年10月16日 上午11:29:20
 * @version 1.0.0
 */
@Service
public class ServiceContext implements ApplicationContextAware {
	
	private static Logger logger = LoggerFactory.getLogger(ServiceContext.class.getClass());
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ServiceContext.context = context;
		logger.info(ServiceContext.class.getSimpleName() + " is initialized.");
	}
	
	public static ApplicationContext getContext() {
		if (ServiceContext.context == null) {
			throw new IllegalStateException(ServiceContext.class.getSimpleName() + " not yet initialized!");
		}
		return ServiceContext.context;
	}
}
