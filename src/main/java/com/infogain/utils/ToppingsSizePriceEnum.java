package com.infogain.utils;

public enum ToppingsSizePriceEnum {

	Small(15),Medium(30),Large(45);

	private final Integer value;

	private ToppingsSizePriceEnum(Integer value) {
		this.value = value;
	}
	public Integer toInteger() {
		return value;
	}
}
