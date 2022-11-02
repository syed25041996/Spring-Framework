package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyAppBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("=========postProcessBeforeInitialization===========");
		System.out.println("The bean name before initialization : " + beanName);
		return bean;

	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("========postProcessAfterInitialization===============");
		LifeCycleBean life = (LifeCycleBean) bean;
		life.setTitle("lifecycle v2");
		System.out.println("After post proccess new title : " + life.getTitle());
		return bean;
		
	}

	
}
