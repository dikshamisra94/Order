package com.infogain.utils;

public enum PizzaCheeseEnum {

	Mozzarella("Mozzarella"),Cream_Cheese("Cream Cheese");

	private final String value;

	private PizzaCheeseEnum(String value) {
		this.value = value;
	}
	public String toString() {
		return value;
	}
}
