package com.infogain.utils;

public enum PizzaSizeEnum {

	Small(0),Medium(.25),Large(.5);

	private final double value;

	private PizzaSizeEnum(double value) {
		this.value = value;
	}
	public double toDouble() {
		return value;
	}
}
