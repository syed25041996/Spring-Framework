package com.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
	
		AbstractApplicationContext iocContainer = new ClassPathXmlApplicationContext("beans.xml");

		Item item = (Item) iocContainer.getBean("item");

		Order order = (Order) iocContainer.getBean("order");
		
//		LifeCycleBean bean = (LifeCycleBean) iocContainer.getBean("lifecycle");

		System.out.println("Item is :" + item.toString());
		System.out.println("Order is :" + order.toString());

//		bean.setTitle("MyBean");
//		System.out.println("Bean is: " + bean.getTitle() );
//		System.out.println("================================");
		
		iocContainer.close();
		
	}
}
