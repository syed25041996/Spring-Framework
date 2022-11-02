package com.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {
	
	String title;

	public LifeCycleBean() {
		super();
		System.out.println("Inisde constructor");
	}

	public LifeCycleBean(String title) {
		super();
		this.title = title;
		System.out.println("Inside parametrized constructor");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("Inside setter method");
	}

	@Override
	public String toString() {
		return "LifeCycleBean [title=" + title + "]";
	}

	//Bean Name aware interface
	public void setBeanName(String name) {
		System.out.println("Bean name is : " + name);
		
	}

	//Disposable bean
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside disposable bean");
	}

	//Initalizing bean
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside Initializing bean");
		
	}
	
	public void myInit() {
		System.out.println("Inside custom init-method");
	}
	
	public void myDestroy() {
		System.out.println("Inside custom destroy-method");
	}
	

}
