package com.spring;

public class Item {

	String name;
	int price;

	public Item() {
		super();
		System.out.println("Inisde the item constructor....");
	
	}
	
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void initMethod() {
		System.out.println("In item init method.....");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("In item setter method.....");
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void destroyMethod() {
		System.out.println("In destroy method.....");
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}

}
