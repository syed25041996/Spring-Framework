package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Order {

	@Autowired	
	@Qualifier("item_2")
	Item item;
	String title;

	public Order() {
		super();
		System.out.println("Inisde the order constructor....");
	}
	
	
	public Order(Item item) {
		super();
		this.item = item;
	}

	public Order(Item item, String title) {
		super();
		this.item = item;
		this.title = title;
	}
	
	public void initMethod() {
		System.out.println("In order init method.....");
	}
	

	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		System.out.println("In order setter method.....");
		this.item = item;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void myPreDestroy() {
		System.out.println("In destroy method.....");
	}

	@Override
	public String toString() {
		return "Order [item=" + item + ", title=" + title + "]";
	}
	
	

}
