package com.infogain.utils;

public enum PizzaSauceEnum {

	Margarita("Margarita") , Maxican_Salsa ("Maxican Salsa");

	private final String value;

	private PizzaSauceEnum(String value) {
		this.value = value;
	}
	public String toString() {
		return value;
	}
}
