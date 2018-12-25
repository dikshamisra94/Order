package com.infogain.utils;

public enum PizzaToppingsEnum {

	Capsicum("Capsicum"),Onion("Onion"),Tomato("Tomato"),Corn("Corn"),Baby_Corn("Baby Corn"),Jalapeno("Jalapeno"),Black_Olive("Black Olive"),Paneer("Paneer"),Red_Pepper("Red Pepper");

	private final String value;

	private PizzaToppingsEnum(String value) {
		this.value = value;
	}
	public String toString() {
		return value;
	}
}
